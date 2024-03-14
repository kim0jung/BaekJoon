import java.util.*
import kotlin.math.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val count = scanner.nextInt()
    val result = IntArray(count)

    for (i in 0 until count) {
        val x1 = scanner.nextInt()
        val y1 = scanner.nextInt()
        val r1 = scanner.nextInt()
        val x2 = scanner.nextInt()
        val y2 = scanner.nextInt()
        val r2 = scanner.nextInt()
        val distance = sqrt((x2 - x1).toDouble() * (x2 - x1) + (y2 - y1).toDouble() * (y2 - y1)) // 두 점 사이의 거리 구함

        if (x1 !in -10000..10000 || y1 !in -10000..10000 || x2 !in -10000..10000 || y2 !in -10000..10000 ||
            r1 !in 1..10000 || r2 !in 1..10000
        ) {
            println("입력값이 범위를 벗어났습니다.")
            return // 함수 실행 종료
        } else {
            if (distance == 0.0) {
                if (r1 == r2) result[i] = -1
                else result[i] = 0
            } else {
                val rSum = r1 + r2
                val rDiff = abs(r1 - r2)

                if (distance > rSum) result[i] = 0 // 외부에서 만나는 경우
                else if (distance < rDiff) result[i] = 0 // 외부에서 만나는 경우
                else if (distance.toInt().equals(rSum) || distance.toInt().equals(rDiff)) result[i] =
                    1 // 한 점에서 만나는 경우
                else result[i] = 2 // 두 점에서 만나는 경우
            }
        }
    }
    result.forEach { println(it) }
}





