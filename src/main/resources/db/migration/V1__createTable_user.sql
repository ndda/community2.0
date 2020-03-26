create table user(
    id int primary key auto_increment,
    name varchar(10) null,
    accountId int unique not null,
    password varchar(20),
    token char(36),
    gmtCreate bigint(20),
    gmtModify bigint(20),
    avatarUrl varchar(100)
);