# test_gp_sol_jundev

Performing a test task

## task 548

Минимальное число https://acmp.ru/index.asp?main=task&id_task=548

Требуется написать программу, которая из цифр двух натуральных чисел создает наименьшее возможное
число, сохраняя при этом порядок следования цифр в этих числах.

* Входные данные Входной файл INPUT.TXT содержит два натуральных числа, записанных в двух строках.
  Числа больше нуля и меньше 10^255.

* Выходные данные В единственную строку выходного файла OUTPUT.TXT нужно вывести наименьшее
  возможное число, удовлетворяющее условию задачи.

ПРИМЕР

INPUT.TXT(125, 34) OUTPUT.TXT(12345)

## task 193

Поиск прямоугольников https://acmp.ru/index.asp?main=task&id_task=193

На поле N×M клеток (N строк
и M столбцов) положили K прямоугольников один поверх другого в случайном порядке. Длины сторон
прямоугольников выражаются целым числом клеток. Прямоугольники не выходят за границы поля.
Границы прямоугольников совпадают с границами клеток поля.

Получившуюся ситуацию записали в таблицу чисел (каждой клетке поля соответствует клетка таблицы).
Если клетка поля не закрыта прямоугольником, то в соответствующую клетку таблицы записали число 0.
Если же клетка закрыта одним или несколькими прямоугольниками, то в соответствующую клетку
таблицы записали число, соответствующее номеру самого верхнего прямоугольника, закрывающего эту
клетку.

Требуется написать программу, которая определит положение и размеры прямоугольников.
Гарантируется, что во входных данных содержится информация, которой достаточно для однозначного
определения размеров прямоугольников.

* Входные данные Входной файл INPUT.TXT содержит в первой строке целые числа N, M, K (1 ≤ N ≤ 200,
  1 ≤ M ≤ 200, 1 ≤ K ≤ 255). Далее следует N строк по M чисел в каждой — содержимое таблицы. Все
  числа в таблице целые, находятся в диапазоне от 0 до K включительно.
* Выходные данные Поиск прямоугольниковВыходной файл OUTPUT.TXT должен содержать K строк. Каждая
  строка должна описывать соответствующий ее номеру прямоугольник четырьмя числами X1 Y1 X2 Y2 (X1
  и Y1 должны описывать координаты левого нижнего угла прямоугольника, а X2 и Y2 — координаты
  правого верхнего угла). Числа должны разделяться пробелом.

* Начало координат расположено в левом нижнем углу таблицы. Таким образом, координаты левого
  нижнего угла поля — (0,0), правого верхнего — (M,N).

ПРИМЕР

INPUT.TXT(

4 5 2

0 2 2 2 2

0 2 2 2 2

1 1 2 2 2

1 1 0 0 0)

OUTPUT.TXT(

0 0 2 2

1 1 5 4)

## task 492

Сближение с целью https://acmp.ru/index.asp?main=task&id_task=492

Вы являетесь одним из разработчиков программного обеспечения боевой информационной системы для
ракетного крейсера нового поколения РК-2000. Один из компонентов этой системы отвечает за решение
задач тактического маневрирования. В настоящее время вы занимаетесь решением задачи о сближении с
целью.

Заданы координаты x0 и y0 цели в начальный момент времени, а также вектор (Vx; Vy) ее скорости.
Считается, что цель движется равномерно и прямолинейно. В начальный момент времени РК-2000 находится
в начале координат. Его максимальная скорость равна V.

Необходимо выяснить, может ли РК-2000 через заданное время t оказаться ровно на заданном расстоянии
d от цели. Для простоты считайте, что РК-2000 может мгновенно изменять свою скорость.

* Входные данные
  Первая строка входного файла INPUT.TXT содержит два целых числа x0 и y0 (|x0| ≤ 10^9, |y0| ≤
  10^9).
  Вторая строка входного файла содержит два целых числа Vx и Vy (|Vx| ≤ 10^6, |Vy| ≤ 10^6). Третья
  строка входного файла содержит три целых числа: V , t, d (1 ≤ V ≤ 10^6, 1 ≤ t ≤ 10^3, 1 ≤ d ≤
  10^9).

* Выходные данные
  В выходной файл OUTPUT.TXT выведите YES, если РК-2000 может через заданное время t оказаться ровно
  на заданном расстоянии d от цели, и NO – в противном случае.

ПРИМЕРЫ

INPUT.TXT(

1 1

1 1

1 1 1
)

OUTPUT.TXT(
NO
)

## task 109

A / B https://acmp.ru/index.asp?main=task&id_task=109

Требуется получить точное значение частного А/В для двух натуральных чисел A и B.

* Входные данные
  В единственной строке входного файла INPUT.TXT записано частное двух натуральных чисел, не
  превышающих 1000. Числа разделены символом «/» без лишних пробелов.
* Выходные данные
  В выходной файл OUTPUT.TXT нужно вывести точное значение A/B без лишних точек, нулей и пробелов. В
  случае присутствия бесконечной записи числа следует вывести период в скобках.

Например, неправильно выведены числа: 08.92, 3.20, 120.6(6), 0.(33), 5.(0), 2. , .3, 0.33(03) . Их
следует выводить как 8.92, 3.2, 120.(6), 0.(3), 5, 2, 0.3, 0.3(30) .

ПРИМЕРЫ

INPUT.TXT(
1 10/7
2 1/3
3 100/25)

OUTPUT.TXT (
1.(428571)
0.(3)
4 )

## task346 
Сумма двух чисел https://acmp.ru/index.asp?main=task&id_task=346

Заданы три числа: a, b, c. Необходимо выяснить, можно ли так переставить цифры в числах a и b, чтобы
в сумме получилось c.
* Входные данные
* 
Входной файл INPUT.TXT содержит три целых числа: a, b, c (0 ≤ a, b, c < 109). Числа разделены
пробелом.
* Выходные данные
* 
В выходной файл OUTPUT.TXT следует вывести YES, если искомая перестановка цифр возможна, в противном
случае необходимо вывести NO. При положительном ответе во второй строке следует вывести число x,
получаемое перестановкой цифр числа a, и число y, получаемое перестановкой цифр числа b, сумма
которых равна c. Числа x и y при выводе не должны содержать ведущих нулей. Числа в строке разделены
пробелом. Если решений несколько, то следует вывести ту пару, в которой число x минимально.

ПРИМЕР

INPUT.TXT(
1	12 31 25
2	12 31 26	
3	101 2 13
)

OUTPUT.TXT(
1   YES
    12 13
2	NO
3	YES
    11 2
)