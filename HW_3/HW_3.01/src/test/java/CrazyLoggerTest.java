import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrazyLoggerTest {
    CrazyLogger crazyLogger;

    @BeforeEach
    void setUp() {
        crazyLogger = new CrazyLogger(new StringBuilder("24-06-2018 : 09-31 - CrazyLogger is initialized!\n" +
                "24-06-2018 : 09-32 - GET /twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1 401 12846\n" +
                "24-06-2018 : 09-33 - GET /twiki/bin/rdiff/TWiki/NewUserTemplate?rev1=1.3&rev2=1.2 HTTP/1.1 200 4523\n" +
                "24-06-2018 : 09-34 - GET /mailman/listinfo/hsdivision HTTP/1.1 200 6291\n" +
                "24-06-2018 : 09-35 - GET /twiki/bin/view/TWiki/WikiSyntax HTTP/1.1 200 7352\n" +
                "24-06-2018 : 09-36 - POST /twiki/bin/view/Main/DCCAndPostFix HTTP/1.1 200 5253\n" +
                "24-06-2018 : 09-37 - GET /twiki/bin/oops/TWiki/AppendixFileSystem?template=oopsmore¶m1=1.12¶m2=1.12 HTTP/1.1 200 11382\n" +
                "24-06-2018 : 09-38 - GET /twiki/bin/view/Main/PeterThoeny HTTP/1.1 200 4924\n" +
                "24-06-2018 : 09-39 - GET /twiki/bin/edit/Main/Header_checks?topicparent=Main.ConfigurationVariables HTTP/1.1 401 12851\n" +
                "24-06-2018 : 09-40 - POST /twiki/bin/attach/Main/OfficeLocations HTTP/1.1 401 12851\n" +
                "24-06-2018 : 09-41 - GET /twiki/bin/view/TWiki/WebTopicEditTemplate HTTP/1.1 200 3732\n" +
                "24-06-2018 : 09-43 - POST /mailman/listinfo/business HTTP/1.1 200 6379\n" +
                "24-06-2018 : 09-44 - GET /twiki/bin/rdiff/Main/WebIndex?rev1=1.2&rev2=1.1 HTTP/1.1 200 46373\n" +
                "24-06-2018 : 09-45 - POST /twiki/bin/view/TWiki/DontNotify HTTP/1.1 200 4140\n" +
                "24-06-2018 : 09-46 - GET /twiki/bin/view/Main/TokyoOffice HTTP/1.1 200 3853\n" +
                "24-06-2018 : 09-47 - GET /twiki/bin/view/Main/MikeMannix HTTP/1.1 200 3686\n" +
                "24-06-2018 : 09-48 - GET /twiki/bin/attach/Main/PostfixCommands HTTP/1.1 401 12846\n" +
                "24-06-2018 : 09-50 - GET /robots.txt HTTP/1.1 200 68"));
    }

    @Test
    void getMessageByPhrase1() {
        // POST
        StringBuilder expected = new StringBuilder("24-06-2018 : 09-36 - POST /twiki/bin/view/Main/DCCAndPostFix HTTP/1.1 200 5253\n" +
                "24-06-2018 : 09-40 - POST /twiki/bin/attach/Main/OfficeLocations HTTP/1.1 401 12851\n" +
                "24-06-2018 : 09-43 - POST /mailman/listinfo/business HTTP/1.1 200 6379\n" +
                "24-06-2018 : 09-45 - POST /twiki/bin/view/TWiki/DontNotify HTTP/1.1 200 4140\n");
        StringBuilder actual = crazyLogger.getMessageByPhrase("POST");
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getMessageByPhrase2() {
        // POST
        StringBuilder expected = new StringBuilder("24-06-2018 : 09-32 - GET /twiki/bin/edit/Main/Double_bounce_sender?topicparent=Main.ConfigurationVariables HTTP/1.1 401 12846\n" +
                "24-06-2018 : 09-39 - GET /twiki/bin/edit/Main/Header_checks?topicparent=Main.ConfigurationVariables HTTP/1.1 401 12851\n" +
                "24-06-2018 : 09-40 - POST /twiki/bin/attach/Main/OfficeLocations HTTP/1.1 401 12851\n" +
                "24-06-2018 : 09-48 - GET /twiki/bin/attach/Main/PostfixCommands HTTP/1.1 401 12846\n");
        StringBuilder actual = crazyLogger.getMessageByPhrase("HTTP/1.1 401");
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getMessagesBetweenDates1() {
        StringBuilder expected = new StringBuilder("");
        StringBuilder actual = crazyLogger.getMessagesBetweenDates("25-06-2018 : 09-37", "25-06-2018 : 09-44");
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void getMessagesBetweenDates2() {
        StringBuilder expected = new StringBuilder("24-06-2018 : 09-37 - GET /twiki/bin/oops/TWiki/AppendixFileSystem?template=oopsmore¶m1=1.12¶m2=1.12 HTTP/1.1 200 11382\n" +
                "24-06-2018 : 09-38 - GET /twiki/bin/view/Main/PeterThoeny HTTP/1.1 200 4924\n" +
                "24-06-2018 : 09-39 - GET /twiki/bin/edit/Main/Header_checks?topicparent=Main.ConfigurationVariables HTTP/1.1 401 12851\n" +
                "24-06-2018 : 09-40 - POST /twiki/bin/attach/Main/OfficeLocations HTTP/1.1 401 12851\n" +
                "24-06-2018 : 09-41 - GET /twiki/bin/view/TWiki/WebTopicEditTemplate HTTP/1.1 200 3732\n" +
                "24-06-2018 : 09-43 - POST /mailman/listinfo/business HTTP/1.1 200 6379\n" +
                "24-06-2018 : 09-44 - GET /twiki/bin/rdiff/Main/WebIndex?rev1=1.2&rev2=1.1 HTTP/1.1 200 46373\n");
        StringBuilder actual = crazyLogger.getMessagesBetweenDates("24-06-2018 : 09-37", "24-06-2018 : 09-44");
        assertEquals(expected.toString(), actual.toString());
    }
}