package game.blackjack

import game.blackjack.domain.Deck
import game.blackjack.domain.Participant

/*
    게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
    pobi,jason
    
    pobi, jason에게 2장의 나누었습니다.
    pobi카드: 2하트, 8스페이드
    jason카드: 7클로버, K스페이드
    
    pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
    y
    pobi카드: 2하트, 8스페이드, A클로버
    pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
    n
    jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
    n
    jason카드: 7클로버, K스페이드
    
    pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
    jason카드: 7클로버, K스페이드 - 결과: 17
*/
fun main() {
    // 게임에 참여할 사람을 입력받는다.
    val participants = readln().split(",").map { Participant(it) }

    // 총 52장의 카드로 이루어진 게임 덱을 받는다.
    val deck = Deck()

    // 게임 시작 시 각 참여자들은 2장의 카드를 받는다.
    participants.forEach { it.drawCard(deck.initialDraw()) }
    println(String.format("%s에게 2장을 나누었습니다.", participants.map { it.name }.joinToString(", ")))
    participants.forEach {
        println(
            String.format(
                "%s카드: %d%s, %d%s", it.name,
                it.cards[0].number.value, it.cards[0].shape.value,
                it.cards[1].number.value, it.cards[1].shape.value
            )
        )
    }
}
