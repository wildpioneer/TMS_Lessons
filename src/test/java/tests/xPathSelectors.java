package tests;

public class xPathSelectors {
    private static String absolutePath = "/html/body/div";

    private static String allElementsInHTMLPath = "//*";  // Все элементы на странице начиная с html - тэга

    private static String bodyPath = "//body";  // Элемент по тэгу

    private static String childPath = "//form/input";  // Дочерний элемент относительно родителя

    private static String tagWithAttrPath = "//span[@id='access--1']";  // Поиск элемента с аттрибутом и его значением

    private static String parentPath1 = "//span[@id='access--1']//..";  // Поиск родителя у элемента с аттрибутом и его значением
    private static String parentPath2 = "//*[@id='suite_mode_single']/parent::label;";  // Поиск родителя у элемента с аттрибутом и его значением

    private static String elementByIndexPath = "(//form)[4]";  // Поиск элемента по индексу

    private static String searchByTextPath = "//*[text()='New Widget']";  // Поиск элемента по полному соответствию по тексту
    private static String searchByTextPath1 = "//*[.='New Widget']";  // Поиск элемента по полному соответствию по тексту

    private static String searchBySubstringPath = "//*[contains(text(),'Widget')]";   // Поиск элемента по подстроке в тексте

    private static String searchByStartsWithPath = "//input[starts-with(@type, 'hi')]";//Поиск элемента по аттрибуту значение которого начинается с
    private static String searchByTwoAttrPath = "//*[@class='form-control ' and @type='text']";   // Использование логического оператора


    private static String searchBySpecificAttrPath = "//input[@type != 'hidden']";   // Использование логического оператора

    //Axes - Оси
    //Использование ancestor - все предки текущего узла
    private static String path1 = "//*[@id='suite_mode_single_baseline']/ancestor::div";

    //Использование child - все предки текущего узла зависят от уровня
    private static String path2_1 = "//ul/child::li";
    private static String path2_2 = "//ul/li";  // аналог только проще

    //Использование descendant - Все предки текущего узла не зависимо от уровня
    private static String path3_1 = "//ul/descendant::span";
    private static String path3_2 = "//ul//span";  // аналог только проще

    //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
    private static String path4_1 = "//label[@for='announcement']/following::form";
    private static String path4_2 = "(//label[@for='announcement']/following::div/*[@class='checkbox'])[1]";

    //Использование following-sibling - Выбирает все узлы одного уровня после текущего узла
    private static String path5_1 = "//label[@for='announcement']/following-sibling::div";

    //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
    private static String path6_1 = "//label[@for='announcement']/preceding::div";

    //Использование preceding-sibling - Выбирает все узлы одного уровня до текущего узла
    private static String path7_1 = "//label[@for='announcement']/preceding-sibling::div";
}
