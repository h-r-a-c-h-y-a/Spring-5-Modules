package am.gitc.spring5_boot_mvc;

import am.gitc.spring5_boot_mvc.entities.Singer;
import am.gitc.spring5_boot_mvc.entities.Singers;
import am.gitc.spring5_boot_mvc.service.SingerService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingerControllerTest {

    private final List<Singer> singers = new ArrayList<>();

    @Before
    public void initSingers() {
        Singer singer = new Singer();
        singer.setId(1L);
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singers.add(singer);
    }

    @Test
    public void testList() {
        SingerService service = mock(SingerService.class);
        when(service.findAll()).thenReturn(singers);
        SingerController controller = new SingerController();
        ReflectionTestUtils.setField(controller, "singerService", service);
        ExtendedModelMap uiModel = new ExtendedModelMap();
        uiModel.addAttribute("singers", controller.listData());

        Singers modelSingers = (Singers) uiModel.get("singers");

        assertEquals(1, modelSingers.getSingers().size());
    }

    @Test
    public void testCreate() {
        final Singer newSinger = new Singer();
        newSinger.setId(9991L);
        newSinger.setFirstName("BB");
        newSinger.setLastName("King");
        SingerService singerService = mock(SingerService.class);
        when(singerService.save(newSinger)).thenAnswer((invocationOnMock -> {
            singers.add(newSinger);
            return newSinger;
        }));

        SingerController singerController = new SingerController();
        ReflectionTestUtils.setField(singerController, "singerService", singerService);

        Singer singer = singerController.create(newSinger);
        assertEquals(Long.valueOf(9991), singer.getId());
        assertEquals("BB", singer.getFirstName());
        assertEquals("King", singer.getLastName());
        assertEquals(2, singers.size());
    }
}
