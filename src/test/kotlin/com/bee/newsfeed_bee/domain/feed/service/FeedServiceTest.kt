package com.bee.newsfeed_bee.domain.feed.service

import com.bee.newsfeed_bee.domain.feed.entity.Feed
import com.bee.newsfeed_bee.domain.feed.repository.FeedRepository
import io.kotest.core.annotation.DisplayName
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.ints.shouldBeExactly
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import java.time.OffsetDateTime

@DisplayName("FeedService")
@ActiveProfiles("test1")
@TestConstructor(autowireMode = ALL)
@SpringBootTest
// class FeedServiceTest @Autowired constructor(
class FeedServiceTest (
    private val feedService: FeedService,
    private val feedRepository: FeedRepository
    // Kotest 테스트 수명 주기 DescribeSpec 기준
    // (cf.) Kotest 테스트 수명 주기 BehaviorSpec 기준 - https://velog.io/@effirin/Kotest와-BDD-테스트-코드-작성하기-전-읽어두면-좋을-자료들
    //   - 참고 영상 https://youtu.be/PqA6zbhBVZc?si=X1_i-UPNABsbENrz&t=529
) : DescribeSpec({

    fun createThreeFeeds(): List<Feed> {
        return listOf(
            Feed(null, 1, "아무 한식", "한식", "서울특별시 종로구 종로 1", 3, OffsetDateTime.now(), false, 3, "후기 내용 아무렇게"),
            Feed(null, 1, "양식 가게", "양식", "서울특별시 종로구 세종대로 175", 3, OffsetDateTime.now().plusHours(1), true, 4, "별로"),
            Feed(null, 3, "중국집", "중식", "서울특별시 종로구 종로 1", 5, OffsetDateTime.now().plusHours(2), false, 2, "아주 맛있었다."),
        )
    }

    afterContainer { feedRepository.deleteAll() }

    describe("getFeedList() 메서드는") {
        context("DB에 저장되어 있는 Feed가 없다면,") {
            it("size가 0인 리스트를 반환한다.") {
                feedService.getFeedList(pageNumber, category).size shouldBeExactly 0
            }
        }

        context("DB에 4개의 Feed가 저장되어 있고, 첫번째로 저장된 Feed의 storeName이 \"첫번째 식당\"이라면") {
            val feeds = createThreeFeeds().toMutableList()
            Feed(null, 2, "첫번째 식당", "양식", "서울특별시", 1, OffsetDateTime.now().plusHours(2), false, 2, "아주 맛있었다.")
                .let { feeds.add(0, it) }
            feedRepository.saveAll(feeds)

            it("size가 4인 리스트를 반환하고, 리스트의 첫번째 Feed의 storeName은 \"첫번째 식당\"이다.") {
                feedService.getFeedList(pageNumber, category).size shouldBeExactly 4
                feedService.getFeedList(pageNumber, category)[0].storeName shouldBeEqual "첫번째 식당"
            }
        }
    }
})
