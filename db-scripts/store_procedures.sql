use micro_grid;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getRequiredREGenerationData`(
	in mgc_id varchar(100),
    in port_cfg_ varchar(10),
    in year_ varchar(10),
    in month_ numeric)
BEGIN
	select id, sum(kwh) as kwh, event_time 
    from micro_grid.energy_details 
    where microgrid_id=mgc_id 
		and port_cfg=port_cfg_ 
        and year(event_time) = year_ 
        and month(event_time) = month_ 
        group by day(event_time);
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getREGenDataForPastThreeMonths`(
in m_id varchar(100),
in port_cfg_ varchar(100)
)
BEGIN
	select (select sum(micro_grid.energy_details.kwh) from micro_grid.energy_details where microgrid_id=m_id and port_cfg=port_cfg_ and year(event_time) = year(now()) and month(event_time) = month(date_sub(now(), interval 1 month))) as lastMonth
, (select sum(micro_grid.energy_details.kwh) from micro_grid.energy_details where microgrid_id=m_id and port_cfg=port_cfg_ and year(event_time) = year(now()) and month(event_time) = month(date_sub(now(), interval 2 month))) as secondLast
, (select sum(micro_grid.energy_details.kwh) from micro_grid.energy_details where microgrid_id=m_id and port_cfg=port_cfg_ and year(event_time) = year(now()) and month(event_time) = month(date_sub(now(), interval 3 month))) as thirdLast,
(select monthname(date_sub(now(), interval 1 month))) as lastM,
(select monthname(date_sub(now(), interval 2 month))) as slM,
(select monthname(date_sub(now(), interval 3 month))) as tlM;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMCStatus`(in micro_id varchar(200))
BEGIN
	select * from micro_grid.micro_controller_status 
    where micro_grid_id = micro_id 
    and date(updated_at) = date(now())
	and time(updated_at) <= time(now()) 
    and time(updated_at) >= time(date_sub(now(), interval 3 hour));
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`%` PROCEDURE `getCurrentStatus`(
	in m_id_ varchar(200), 
    in port_ varchar(200))
BEGIN
	select * from micro_grid.energy_details 
    where microgrid_id=m_id_ and 
    port_cfg=port_ and
    date(event_time) = date(now()) and 
    time(event_time) <= time(now()) and 
    time(event_time) >= time(date_sub(now(), interval 30 second));
END$$
DELIMITER ;


