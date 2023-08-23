package day06_Junit;

import org.junit.*;

public class C02_BeforeAfter {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'dan once 1 kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodundan once bir kez @Before calisir");
    }

    @Test
    public void test01() {
        System.out.println("test01 calisti");
    }

    @Test
    public void test02() {
        System.out.println("test02 calisti");
    }

    @Test
    public void test03() {
        System.out.println("test03 calisti");
    }

    @Test
    public void test04() {
        System.out.println("test04 calisti");
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kez @After calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'dan sonra 1 kez calisir");
    }

    /*
    Bir class'da 4 tane test methodu 1 tane before 1 tane after method varsa class'da toplam kaç method çalışmış olur
    cevap : 12
     */
    /*
        Junit framework'ünde test'lerinizi istediğiniz sıralamada çalıştırmak isterseniz alfabetik ve numerik olarak
    test methodlarınızı isimlendirmeniz gerekmektedir.
     */
}
