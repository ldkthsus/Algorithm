# select distinct car_id, 
# case when car_id in (select car_id from car_rental_company_rental_history
#                     where '2022-10-16' between start_date and end_date)
#                     then '대여 중'
# else "대여 가능" end as "availavility"
# from car_rental_company_rental_history
# order by car_id desc;

select distinct CAR_ID, 
    case 
        when CAR_ID in (
            select CAR_ID
            from CAR_RENTAL_COMPANY_RENTAL_HISTORY
            where '2022-10-16' between START_DATE and END_DATE
        ) then '대여중'
        else '대여 가능'
        end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID desc;