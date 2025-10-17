# select distinct car_id, 
# case when car_id in (select car_id from car_rental_company_rental_history
#                     where '2022-10-16' between start_date and end_date)
#                     then '대여 중'
# else "대여 가능" end as "availavility"
# from car_rental_company_rental_history
# order by car_id desc;

SELECT CAR_ID,
       CASE WHEN CAR_ID IN (SELECT CAR_ID
                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                            WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE) THEN '대여중'
       ELSE '대여 가능' END AS AVAILABILITY
FROM (SELECT DISTINCT CAR_ID
      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) AS CARS
ORDER BY CAR_ID DESC;