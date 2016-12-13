package koreatech.cse.domain;

/**
 * Created by YDK on 2016-12-06.
 */
public class Assi {
    private String title;
    private String lectureLectureValue;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Assi(String title, String content){
        this.title = title;
        this.content = content;
        this.lectureLectureValue = null;
    }

    public Assi(){
        this.title = null;
        this.lectureLectureValue = null;
        this.content = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLectureLectureValue() {
        return lectureLectureValue;
    }

    public void setLectureLectureValue(String lectureLectureValue) {
        this.lectureLectureValue = lectureLectureValue;
    }
}


/*
<strong>웹서비스컴퓨팅및실습_1분반</strong>
<input type="hidden" name="lectureLectureValue"    value="30818"        /><!-- 강의과목 내 활성화된 과목의 Seq-->
<input type="hidden" name="stdViewLectureValue"    value="N"                        /><!-- 학생,조교(N) -->
<input type="hidden" name="stdIdLectureValue"      value="0"                        /><!-- 강의만족도설문참여(0,1) -->
<input type="hidden" name="loginIdLectureValue"    value="Y"                        /><!-- 강제성여부(Y,N) -->
<input type="hidden" name="onoffGbnLectureValue"   value=""                         /><!-- 강제성여부(Y,N) -->
<input type="hidden" name="tempLectureValue"       value=""                         />
<input type="hidden" name="classNmLectureValue"    value="대학"           /><!-- 구분(학위/비학위) -->
<input type="hidden" name="operateGbLectureValue"  value="1"         /><!-- 2 -->
<input type="hidden" name="stdYn" value="N"/><!-- 교수자 화면으로 넘기기 위한 변수 -->
<input type="hidden" name="stdUrl" value="" />
*/