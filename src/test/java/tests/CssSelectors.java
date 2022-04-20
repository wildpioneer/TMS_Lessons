package tests;

import org.openqa.selenium.By;

public class CssSelectors {

    private void cssSelectors(){
        By classSelector = By.cssSelector(".radio"); //Поиск по классу radio
        By classSelector1 = By.className("radio"); //Поиск по классу radio

        By idSelector = By.cssSelector("#suite_mode_single"); //Поиск по id
        By idSelector1 = By.id("#suite_mode_single"); //Поиск по id

        By tagSelector = By.cssSelector("label"); //Поиск по tag
        By tagSelector1 = By.tagName("label"); //Поиск по tag

        By tagAttributeSelector = By.cssSelector("label[for='name']"); //Поиск по tag и аттрибуту с значением
        By tagAttributeSelector1 = By.cssSelector("label[for]"); //Поиск по tag и присутсвием аттрибута

        By multipleClassesSelector = By.cssSelector(".column.overflow-content"); //Поиск по двум классам в элементе
        By simpleHierarchicalSelector = By.cssSelector(".table .content-inner"); //Поиск простого дочернего элемента

        By fullHierarchicalSelector = By.cssSelector("body .table .content-inner"); //Использование 3х уровневой иерархии для поиска дочернего элемента

        By searchLikeContainsSelector = By.cssSelector("form[action*='admin']"); //Поиск с вхождением подстроки в значении аттрибута
        By searchByWordSelector = By.cssSelector("div[class~='column']"); //Поиск с вхождением слова в значении аттрибута

        By valueStartsFromSelector = By.cssSelector("a[href^='https://']"); //Поиск эл  емента с аттрибутом значение которого начинается с

        By valueEndsWithSelector = By.cssSelector("a[href$='@gmail.com']"); //Поиск элемента с аттрибутом значение которого аканчивается на

        By childRightAfterParentSelector = By.cssSelector("ul>li"); //Поиск дочернего li у которого родитель ul

        By elementRightAfterElementSelector = By.cssSelector("form+script"); //Поиск элемента script который идет сразу после элемента #form
        By elementOnTheSameLevelSelector = By.cssSelector("form~script"); //Поиск элемента script которым предшествует элемент #form

        By firstChildSelector = By.cssSelector("li:first-child"); //Поиск 1го дочернего элемента
        By lastChildSelector = By.cssSelector("li:last-child"); //Поиск последнего дочернего элемента
        By nthChildFromBeginSelector = By.cssSelector("li:nth-child(2)"); //Поиск n-го дочернего элемента с начала
        By nthChildFromEndSelector = By.cssSelector("li:nth-last-child(3)"); //Поиск n-го дочернего элемента с конца

    }
}
