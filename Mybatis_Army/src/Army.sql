create table UNITS(
units_seq varchar2(10) primary key,--�����ȣ
units_name varchar2(20),--�����̸�
unit_username varchar2(20),
unit_password varchar2(20)
)
create sequence units_seq

create table SUPPLIES(
supplies_seq varchar2(10) primary key,--����ǰ ��ȣ
supply_class varchar2(10),--����ǰ����
supplies_name varchar2(100),--����ǰ�̸�
supplies_quantity number(32),--����ǰ����
units_seq  varchar2(10),
	constraint UNITS_SUPPLIES_FK
    foreign key (units_seq)
    references UNITS(units_seq)
)
create sequence supplies_seq

drop table SUPPLIES
drop sequence supplies_seq
drop table UNITS
drop sequence units_seq
select * from units
select * from supplies



insert into SUPPLIES(
	supplies_seq,
	supply_class,
	supplies_name,
	supplies_quantity,
	units_seq
)
values(
	supplies_seq.nextval
	#{supply_class},
	#{supplies_name},
	#{supplies_quantity},
	#{'1'}
)
insert into SUPPLIES(
	supplies_seq,
	supply_class,
	supplies_name,
	supplies_quantity,
	units_seq
)
values(
	supplies_seq.nextval,
	'2��',
	'����ȭ',
	20,
	'3'
)

delete units where units_seq='18'