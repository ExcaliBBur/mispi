# Лабораторная работа №1

<a href = "https://github.com/ExcaliBBur/mispi/tree/main/lab1">Репозиторий</a>

Составить список требований, предъявляемых к разрабатываемому веб-сайту (в соответствии с вариантом). Требования должны делиться на следующие категории:

* Функциональные. <br/>

    a. Требования пользователей сайта. <br/>
    b. Требования владельцев сайта.
  
* Нефункциональные.
  
Требования необходимо оформить в соответствии с шаблонами RUP (документ SRS - Software Requirements Specification). Для каждого из требований нужно указать его атрибуты (в соответствии с методологией RUP), а также оценить и аргументировать приблизительное количество часов, требующихся на реализацию этого требования.

Для функциональных требований нужно составить UML UseCase-диаграммы, описывающие реализующие их прецеденты использования.

# Лабораторная работа №2

<a href = "https://github.com/ExcaliBBur/mispi/tree/main/lab2">Репозиторий</a>

Сконфигурировать в своём домашнем каталоге репозитории svn и git и загрузить в них начальную ревизию файлов с исходными кодами (в соответствии с выданным вариантом).

Воспроизвести последовательность команд для систем контроля версий svn и git, осуществляющих операции над исходным кодом, приведённые на блок-схеме.

При составлении последовательности команд необходимо учитывать следующие условия:

* Цвет элементов схемы указывает на пользователя, совершившего действие (красный - первый, синий - второй).
* Цифры над узлами - номер ревизии. Ревизии создаются последовательно.
* Необходимо разрешать конфликты между версиями, если они возникают.

# Лабораторная работа №3 

<a href = "https://github.com/ExcaliBBur/mispi/tree/main/lab3">Репозиторий</a>

Написать сценарий для утилиты Apache Ant, реализующий компиляцию, тестирование и упаковку в jar-архив кода проекта из <a href = "https://github.com/ExcaliBBur/web_labs">лабораторной работы #3</a> по дисциплине "Веб-программирование".

Каждый этап должен быть выделен в отдельный блок сценария; все переменные и константы, используемые в сценарии, должны быть вынесены в отдельный файл параметров; MANIFEST.MF должен содержать информацию о версии и о запускаемом классе.

Cценарий должен реализовывать следующие цели (targets):


* compile -- компиляция исходных кодов проекта.
* build -- компиляция исходных кодов проекта и их упаковка в исполняемый jar-архив. Компиляцию исходных кодов реализовать посредством вызова цели compile.
* clean -- удаление скомпилированных классов проекта и всех временных файлов (если они есть).
* test -- запуск junit-тестов проекта. Перед запуском тестов необходимо осуществить сборку проекта (цель build).
* xml - валидация всех xml-файлов в проекте.
* doc - добавление в MANIFEST.MF MD5 и SHA-1 файлов проекта, а также генерация и добавление в архив javadoc по всем классам проекта.
* native2ascii - преобразование native2ascii для копий файлов локализации (для тестирования сценария все строковые параметры необходимо вынести из классов в файлы локализации).
* report - в случае успешного прохождения тестов сохраняет отчет junit в формате xml, добавляет его в репозиторий svn и выполняет commit.
* team - осуществляет получение из svn-репозитория 3 предыдущих ревизий, их сборку (по аналогии с основной) и упаковку получившихся jar-файлов в zip-архив. Сборку реализовать посредством вызова цели build.
* env - осуществляет сборку и запуск программы в альтернативных окружениях; окружение задается версией java и набором аргументов виртуальной машины в файле параметров.

# Лабораторная работа №4

<a href = "https://github.com/ExcaliBBur/mispi/tree/main/lab4">Репозиторий</a>

Для своей программы из <a href = "https://github.com/ExcaliBBur/web_labs">лабораторной работы #3</a> по дисциплине "Веб-программирование" реализовать:
   
* MBean, считающий общее число установленных пользователем точек, а также число точек, попадающих в область. В случае, если пользователь совершил 4 "промаха" подряд, разработанный MBean должен отправлять оповещение об этом событии.
* MBean, определяющий площадь получившейся фигуры.
  
С помощью утилиты JConsole провести мониторинг программы:
  
* Снять показания MBean-классов, разработанных в ходе выполнения задания 1.
* Определить время (в мс), прошедшее с момента запуска виртуальной машины.
  
С помощью утилиты VisualVM провести мониторинг и профилирование программы:
  
* Снять график изменения показаний MBean-классов, разработанных в ходе выполнения задания 1, с течением времени.
* Определить имя класса, объекты которого занимают наибольший объём памяти JVM; определить пользовательский класс, в экземплярах которого находятся эти объекты.
  
С помощью утилиты VisualVM и профилировщика IDE NetBeans, Eclipse или Idea локализовать и устранить проблемы с производительностью в программе. По результатам локализации и устранения проблемы необходимо составить отчёт, в котором должна содержаться следующая информация:
  
* Описание выявленной проблемы.
* Описание путей устранения выявленной проблемы.
* Подробное (со скриншотами) описание алгоритма действий, который позволил выявить и локализовать проблему.
Студент должен обеспечить возможность воспроизведения процесса поиска и локализации проблемы по требованию преподавателя.
