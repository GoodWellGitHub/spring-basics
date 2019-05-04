UPDATE t_user_exchange_log t SET by_log_id =
    (SELECT b.id FROM
          ( SELECT a.id FROM t_user_exchange_log a
          WHERE type=3 and user_id=t.user_id and settle_price=t.settle_price and add_time-t.add_time<1)
b)
WHERE type = 4 and id='1015848318431010816';



UPDATE t_user_exchange_log  SET by_log_id =c.id
    (SELECT b.id,b.user_id,b.add_time,b.settle_price FROM
          ( select A.id,A.user_id,A.add_time,A.settle_price from t_user_exchange_log A,
          (select user_id,settle_price,add_time from t_user_exchange_log where type=4) B
           where A.type=3 and A.user_id=B.user_id and A.settle_price=B.settle_price and B.add_time-A.add_time<1)b)c
WHERE type = 4 and user_id=c.user_id and settle_price=c.settle_price and add_time-c.add_time<1 and   id='1015848318431010816';




(SELECT b.* FROM( select A.id,A.user_id,A.add_time from t_user_exchange_log A,(select user_id,settle_price,add_time from t_user_exchange_log where type=4) B where A.type=3 and A.user_id=B.user_id and A.settle_price=B.settle_price and B.add_time-A.add_time<1)b );




(SELECT  b.* FROM( select A.id,A.user_id,A.add_time,A.type from t_user_exchange_log A,(select user_id,settle_price,add_time from t_user_exchange_log where type=4) B where A.type=3 and A.user_id=B.user_id and A.settle_price=B.settle_price and B.add_time-A.add_time<1) b );




use socco;
UPDATE t_user_exchange_log pout
SET by_log_id = (
    SELECT pin.id
    FROM (
        SELECT p1.id , p1.user_id, p1.settle_price,p1.add_time,p1.type
        FROM t_user_exchange_log p1
            LEFT JOIN t_user_exchange_log p2
            ON p1.user_id = p2.user_id
            and p1.settle_price = p2.settle_price
            AND p2.add_time - p1.add_time<1
            where p1.type = 3
            and p2.type = 4
    ) pin
    WHERE pin.user_id = pout.user_id
        AND pin.settle_price = pout.settle_price
        AND pout.add_time-pin.add_time >1
        AND pin.type=3 and pout.type=4
);
