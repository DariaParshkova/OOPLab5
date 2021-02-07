import java.awt.geom.Rectangle2D;

/**
 * Этот класс является подклассом FractalGenerator. Он используется для вычисления
 * Фрактал Мандельброта.
 */
public class Mandelbrot extends FractalGenerator
{
    /**
     * Константа для количества максимальных итераций.
     */
    public static final int MAX_ITERATIONS = 2000;
    
    /**
     * Этот метод позволяет генератору фракталов указать, какая часть
     * комплексной плоскости наиболее интересна для фрактала.
     * Ему передается объект прямоугольника, и метод изменяет
     * Поля прямоугольника, чтобы показать правильный начальный диапазон для фрактала.
     * Эта реализация устанавливает начальный диапазон в (-2 - 1.5i) - (1 + 1.5i)
     * или x = -2, y = -1,5, width = height = 3.
     */
    public void getInitialRange(Rectangle2D.Double range)
    {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }
    
    /**
     * Этот метод реализует итерационную функцию для фрактала Мандельброта.
     * Требуется два дубля для действительной и мнимой частей комплекса
     * plane и возвращает количество итераций для соответствующего
     * координата.
     */
    public int numIterations(double x, double y)
    {
        /** Начните с итераций с 0. */
        int iteration = 0;
        /** Initialize zreal and zimaginary. */
        double zreal = 0;
        double zimaginary = 0;
        
        /**
         * Вычислить Zn = Zn-1 ^ 2 + c, где значения представляют собой комплексные числа, представленные
         * по zreal и zimaginary, Z0 = 0, а c - конкретная точка в
         * фрактал, который мы показываем (заданный x и y). Это повторяется
         * до Z ^ 2> 4 (абсолютное значение Z больше 2) или максимум
         * достигнуто количество итераций.
         */
        while (iteration < MAX_ITERATIONS &&
               zreal * zreal + zimaginary * zimaginary < 4)
        {
            double zrealUpdated = zreal * zreal - zimaginary * zimaginary + x;
            double zimaginaryUpdated = 2 * zreal * zimaginary + y;
            zreal = zrealUpdated;
            zimaginary = zimaginaryUpdated;
            iteration += 1;
        }
        
        /**
         * Если достигнуто максимальное количество итераций, верните -1, чтобы
         * указывают, что точка не вышла за границу.
         */
        if (iteration == MAX_ITERATIONS)
        {
            return -1;
        }
        
        return iteration;
    }
    
    /**
     * Реализация toString () в этой реализации фрактала. Возврат
     * название фрактала: «Мандельброт».
     */
    public String toString() {
        return "Mandelbrot";
    }

}