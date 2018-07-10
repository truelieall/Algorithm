import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
Question:
photo.jpg, Warsaw, 2013-09-05 14:08:15
위의 형태로 이루어진 파일리스트를 입력받아
도시별로 규합, 시간순으로 정렬한 후
도시명+seq.jpg 형태로 이루어진 리스트로 반환한다.
반환리스트는 원래 파일 입력순서에 따른다.
*/
public class 파일LIST가공 {

    public static void main(String arg[]) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<100000;i++) {
            sb.append("01");
        }

        String test = "photo.jpg, Warsaw, 2013-09-05 14:08:15\r\n" +
                "myFriends.png, Warsaw, 2013-09-05 14:07:13\r\n" +
                "Eiffel.jpg, Paris, 2015-07-23 08:03:02\r\n" +
                "pisatower.jpg, Paris, 2015-07-22 23:59:59\r\n" +
                "BOB.jpg, London, 2015-08-05 00:02:03\r\n" +
                "notredame.png, Paris, 2015-09-01 12:00:00\r\n" +
                "me.jpg, Warsaw, 2013-09-06 15:40:22\r\n" +
                "a.png, Warsaw, 2016-02-13 13:33:50\r\n" +
                "b.jpg, Warsaw, 2016-01-02 15:12:22\r\n" +
                "c.jpg, Warsaw, 2016-01-02 14:34:30\r\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\r\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\r\n" +
                "f.png, Warsaw, 2016-01-02 10:55:32\r\n" +
                "d.jpg, Warsaw, 2016-01-02 15:15:01\r\n" +
                "e.png, Warsaw, 2016-01-02 09:49:09\r\n" +
                "g.jpg, Warsaw, 2016-02-29 22:13:11\r\n" +
                "john111.png, Seoul, 2015-06-20 15:13:22\r\n" ;

        System.out.println(handleFileList(test));
    }

    public static String handleFileList(String S) {
        String[] list = S.split("\\s*\\r?\\n\\s*");

        int fileNo = 1;

        List<PhotoFile> photoList = new ArrayList<>();

        for(String el : list) {
            photoList.add(new PhotoFile(el, fileNo++));
        }

        //Order by cityname, date
        photoList.sort( (arr1, arr2) -> {
                    int ret;
                    ret = arr1.cityName.compareTo(arr2.cityName) ;

                    if(ret == 0) {
                        ret = arr1.date.compareTo(arr2.date);
                    }
                    return ret;
                }
        );

        tagingSeqNum(photoList);

        //Re order by fileNo (input order)
        photoList.sort((arr1, arr2) -> {
                    if(arr1.fileNo > arr2.fileNo) return 1;
                    else return - 1;
                }
        );

        return createReturnString(photoList);
    }

    //create returnFormat String
    private static String createReturnString(List<PhotoFile> photoList) {
        StringBuilder returnString = new StringBuilder();
        boolean isFirst = true;

        for(PhotoFile el : photoList) {
            if(!isFirst) {
                returnString.append("\r\n");
            }
            isFirst = false;
            returnString.append(el.cityName + el.seq + "." + el.extension);
        }
        return returnString.toString();
    }


    //Tag seqNumber for each file.
    private static void tagingSeqNum(List<PhotoFile> photoList) {
        int seq = 1;
        int startCityIndex = 0;
        String prevCityName = photoList.get(0).cityName;
        int i=0;

        for(i=0; i<=photoList.size();i++) {

            String currCityName = (i >= photoList.size()) ? "" : photoList.get(i).cityName;

            if(!prevCityName.equals(currCityName)) {
                int seqLength = String.valueOf(i - startCityIndex).length();

                for(int j=startCityIndex; j<i;j++) {
                    photoList.get(j).seq = String.format("%0" + seqLength +"d", seq);
                    seq++;
                }
                seq = 1;
                startCityIndex = i;

            }
            prevCityName = currCityName;
        }

    }

    static class PhotoFile{
        int fileNo;
        String seq;
        String photoName;
        String extension;
        String cityName;
        Date date;

        public PhotoFile(String fullName, int fileNo)  {
            this.fileNo = fileNo;
            String[] list = fullName.split(",");

            String[] fileName = list[0].split("\\.");
            this.photoName = fileName[0];
            this.extension = fileName[1];

            this.cityName = list[1].trim();

            SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                this.date = transFormat.parse(list[2]);
            }catch(Exception e) {
                throw new RuntimeException("date trans error : " + list[2]);
            }

            validate();

        }

        private void validate() {
            if(photoName == null || photoName.length() == 0) {
                throw new IllegalArgumentException("photoName is null");
            }
            if(cityName == null || cityName.length() == 0) {
                throw new IllegalArgumentException("cityName is null");
            }
            if(!"jpg".equals(extension) && !"png".equals(extension) && !"jpeg".equals(extension))
                throw new IllegalArgumentException("Wrong extension : " + extension);
        }
    }

}
