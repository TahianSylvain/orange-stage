create database oma;
	alter database oma owner to dre;
drop table personnel;
drop sequence Personnel_SEQ cascade ;
create  sequence  Personnel_SEQ INCREMENT BY 50;
	create table personnel
		(
			id bigint primary key default (nextval('Personnel_SEQ')),
			nom varchar(50) ,
			prenom varchar(50) ,
			age integer
		);