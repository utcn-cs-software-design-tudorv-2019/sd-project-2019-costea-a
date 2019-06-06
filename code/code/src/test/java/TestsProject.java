import com.example.project.Business.*;
import com.example.project.Persistence.Entity.Play;
import com.example.project.Persistence.Entity.Review;
import com.example.project.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Project.class)
public class TestsProject {
    @Inject
    AdminService adminService;

    @Inject
    PlayService playService;

    @Inject
    ReviewService reviewService;

    @Test
    public void getInfoPlay(){
        playService.getAllPlays();
    }

    @Test
    public void deletePlay(){
        Play play = new Play();
        adminService.delete(play);
    }

    @Test
    public void addReview(){
        Review rev = new Review();
        reviewService.create(rev);
    }




}
