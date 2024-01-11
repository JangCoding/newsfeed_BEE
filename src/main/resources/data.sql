insert into feed(created_date_time, last_modified_date_time, user_id, deleted_date_time, store_name, category, address, score, visited_date_time, waited, store_size, content)
values (CURRENT_TIMESTAMP - 100, CURRENT_TIMESTAMP, 1, null, '아무 한식', '한식', '서울특별시 종로구 종로 1', 3, CURRENT_TIMESTAMP, false, 3, '후기 내용 아무렇게'),
       (CURRENT_TIMESTAMP - 99, CURRENT_TIMESTAMP, 1, null, '양식 가게', '양식', '서울특별시 종로구 세종대로 175', 3, CURRENT_TIMESTAMP, true, 4, '별로'),
       (CURRENT_TIMESTAMP - 98, CURRENT_TIMESTAMP, 3, null, '중국집', '중식', '서울특별시 종로구 종로 1', 5, CURRENT_TIMESTAMP, false, 2, '아주 맛있었다.'),
       (CURRENT_TIMESTAMP - 97, CURRENT_TIMESTAMP, 4, null, '아무 한식', '한식', '서울특별시 종로구 종로 1', 3, CURRENT_TIMESTAMP, false, 3, '후기 내용 아무렇게'),
       (CURRENT_TIMESTAMP - 96, CURRENT_TIMESTAMP, 5, null, '양식 가게', '양식', '서울특별시 종로구 세종대로 175', 3, CURRENT_TIMESTAMP, true, 4, '별로'),
       (CURRENT_TIMESTAMP - 95, CURRENT_TIMESTAMP, 2, null, '중국집', '중식', '서울특별시 종로구 종로 1', 5, CURRENT_TIMESTAMP, false, 2, '아주 맛있었다.'),
       (CURRENT_TIMESTAMP - 94, CURRENT_TIMESTAMP, 6, null, '아무 한식', '한식', '서울특별시 종로구 종로 1', 3, CURRENT_TIMESTAMP, false, 3, '후기 내용 아무렇게'),
       (CURRENT_TIMESTAMP - 93, CURRENT_TIMESTAMP, 2, null, '양식 가게', '양식', '서울특별시 종로구 세종대로 175', 3, CURRENT_TIMESTAMP, true, 4, '별로'),
       (CURRENT_TIMESTAMP - 92, CURRENT_TIMESTAMP, 1, null, '중국집', '중식', '서울특별시 종로구 종로 1', 5, CURRENT_TIMESTAMP, false, 2, '아주 맛있었다.'),
       (CURRENT_TIMESTAMP - 91, CURRENT_TIMESTAMP, 8, null, '아무 한식', '한식', '서울특별시 종로구 종로 1', 3, CURRENT_TIMESTAMP, false, 3, '후기 내용 아무렇게'),
       (CURRENT_TIMESTAMP - 90, CURRENT_TIMESTAMP, 10, null, '양식 가게', '양식', '서울특별시 종로구 세종대로 175', 3, CURRENT_TIMESTAMP, true, 4, '별로'),
       (CURRENT_TIMESTAMP - 89, CURRENT_TIMESTAMP, 12, null, '중국집', '중식', '서울특별시 종로구 종로 1', 5, CURRENT_TIMESTAMP, false, 2, '아주 맛있었다.'),
       (CURRENT_TIMESTAMP - 88, CURRENT_TIMESTAMP, 17, null, '중국집', '중식', '서울특별시 종로구 종로 1', 5, CURRENT_TIMESTAMP, false, 2, '아주 맛있었다.');
