create table question(
    id int primary key auto_increment,
    title varchar(50) null,
    description text null,
    accountId int not null,
    tag int(10),
    gmtCreate bigint(20),
    gmtModify bigint(20)
);