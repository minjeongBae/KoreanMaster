package koreanmaster.teachers.teacher.introduction;

import junit.framework.TestCase;

import java.util.List;

public class ImgDAOTest extends TestCase {

    public void testGetImgList() {
        ImgDAO dao = new ImgDAO();
        List<ImgVO> result = dao.getImg();
        for(int i=0; i<result.size(); i++)
            System.out.println(result.get(i).getUrl());
    }
}