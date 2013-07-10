# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table City (
  person_id                 bigint not null,
  name                      varchar(255),
  region                    varchar(255),
  country                   varchar(255),
  country_id                bigint,
  lat                       double,
  lon                       double,
  constraint pk_City primary key (person_id))
;

create table Context (
  context_id                bigint not null,
  title                     varchar(255),
  subtitle                  varchar(255),
  person_for_id             bigint,
  city_for_id               bigint,
  city_ratio                bigint,
  date                      timestamp,
  date_ratio                bigint,
  constraint pk_Context primary key (context_id))
;

create table Country (
  country_id                bigint not null,
  short_name                varchar(255),
  long_name                 varchar(255),
  iso2                      varchar(255),
  iso3                      varchar(255),
  numcode                   varchar(255),
  un_member                 varchar(255),
  calling_code              varchar(255),
  cctld                     varchar(255),
  spanish_name              varchar(255),
  constraint pk_Country primary key (country_id))
;

create table Works (
  work_id                   bigint not null,
  constraint pk_Works primary key (work_id))
;

create table Event (
  event_id                  bigint not null,
  headline                  varchar(255),
  text                      varchar(255),
  type                      varchar(255),
  category                  varchar(255),
  credit                    varchar(255),
  credit_url                varchar(255),
  location_id               bigint,
  fuzzy_startdate           bigint,
  fuzzy_enddate             bigint,
  constraint pk_Event primary key (event_id))
;

create table Famous_Person (
  famous_person_id          bigint not null,
  constraint pk_Famous_Person primary key (famous_person_id))
;

create table Fuzzy_Date (
  fuzzy_date_id             bigint not null,
  textual_date              varchar(255),
  exact_date                timestamp,
  decade                    bigint,
  year                      bigint,
  season                    varchar(255),
  month                     varchar(255),
  day                       varchar(255),
  day_name                  varchar(255),
  day_part                  varchar(255),
  hour                      varchar(255),
  minute                    varchar(255),
  second                    varchar(255),
  accuracy                  bigint,
  locale                    varchar(255),
  constraint pk_Fuzzy_Date primary key (fuzzy_date_id))
;

create table Life_Event (
  life_event_id             bigint not null,
  headline                  varchar(255),
  text                      varchar(255),
  richtext                  varchar(255),
  type                      varchar(255),
  visibility                integer,
  contributor_id            bigint,
  creation_date             timestamp,
  locale                    varchar(255),
  location_id               bigint,
  question_question_id      bigint,
  fuzzy_startdate           bigint,
  fuzzy_enddate             bigint,
  constraint pk_Life_Event primary key (life_event_id))
;

create table Location (
  location_id               bigint not null,
  location_textual          varchar(255),
  accuracy                  integer,
  name                      varchar(255),
  description               varchar(255),
  environment               varchar(255),
  continent                 varchar(255),
  country                   varchar(255),
  region                    varchar(255),
  city                      varchar(255),
  neighborhood              varchar(255),
  street                    varchar(255),
  street_number             varchar(255),
  map_url                   varchar(255),
  coordinates_trust         integer,
  location_type_id          bigint,
  lat                       double,
  lon                       double,
  locate                    varchar(255),
  radius                    bigint,
  constraint pk_Location primary key (location_id))
;

create table Media (
  media_id                  bigint not null,
  constraint pk_Media primary key (media_id))
;

create table Memento (
  memento_id                bigint not null,
  life_event_id             bigint,
  url                       varchar(255),
  thumbnail_url             varchar(255),
  type                      varchar(255),
  category                  varchar(255),
  is_cover                  boolean,
  index                     integer,
  headline                  varchar(255),
  text                      varchar(255),
  public_memento            boolean,
  credit                    varchar(255),
  credit_url                varchar(255),
  location_id               bigint,
  question_question_id      bigint,
  fuzzy_startdate           bigint,
  fuzzy_enddate             bigint,
  constraint pk_Memento primary key (memento_id))
;

create table Person (
  person_id                 bigint not null,
  fullname                  varchar(255),
  firstname                 varchar(255),
  lastname                  varchar(255),
  birthdate                 timestamp,
  birthdate_fuzzy_id        bigint,
  deathdate                 timestamp,
  deathdate_fuzzy_id        bigint,
  birthplace_id             bigint,
  nationality_country_id    bigint,
  gender                    varchar(255),
  famous_id                 bigint,
  constraint pk_Person primary key (person_id))
;

create table Contex_Index (
  context_index_id          bigint not null,
  decade                    bigint,
  year                      bigint,
  distance                  double,
  city_id                   bigint,
  coordinates_trust         integer,
  context_memento_id        bigint,
  url                       varchar(255),
  thumbnail_url             varchar(255),
  headline                  varchar(255),
  text                      varchar(255),
  type                      varchar(255),
  category                  varchar(255),
  credit                    varchar(255),
  credit_url                varchar(255),
  constraint pk_Contex_Index primary key (context_index_id))
;

create table Question (
  question_id               bigint not null,
  question_text             varchar(255),
  category                  varchar(255),
  chapter                   varchar(255),
  locale                    varchar(255),
  ranking                   integer,
  source                    varchar(255),
  present_tense             boolean,
  startdecade               integer,
  enddecade                 integer,
  constraint pk_Question primary key (question_id))
;

create table Question_Trans (
  question_trans_id         bigint not null,
  question_id               bigint,
  question_text             varchar(255),
  category                  varchar(255),
  chapter                   varchar(255),
  locale                    varchar(255),
  fixed                     boolean,
  constraint pk_Question_Trans primary key (question_trans_id))
;

create table timeline (
  timeline_id               bigint not null,
  about_person_id           bigint,
  constraint pk_timeline primary key (timeline_id))
;

create table User (
  user_id                   bigint not null,
  person_id                 bigint,
  nickname                  varchar(60),
  email                     varchar(50),
  lang                      varchar(45),
  email_verified            boolean,
  nickname_verified         boolean,
  profile_pic               varchar(255),
  cryptpass                 varchar(255),
  conf_type                 varchar(255),
  constraint pk_User primary key (user_id))
;


create table Context_Content (
  context_id                     bigint not null,
  context_index_id               bigint not null,
  constraint pk_Context_Content primary key (context_id, context_index_id))
;
create sequence City_seq;

create sequence Context_seq;

create sequence Country_seq;

create sequence Works_seq;

create sequence Event_seq;

create sequence Famous_Person_seq;

create sequence Fuzzy_Date_seq;

create sequence Life_Event_seq;

create sequence Location_seq;

create sequence Media_seq;

create sequence Memento_seq;

create sequence Person_seq;

create sequence Contex_Index_seq;

create sequence Question_seq;

create sequence Question_Trans_seq;

create sequence timeline_seq;

create sequence User_seq;

alter table City add constraint fk_City_country_1 foreign key (country_id) references Country (country_id) on delete restrict on update restrict;
create index ix_City_country_1 on City (country_id);
alter table Context add constraint fk_Context_cityFor_2 foreign key (city_for_id) references City (person_id) on delete restrict on update restrict;
create index ix_Context_cityFor_2 on Context (city_for_id);
alter table Event add constraint fk_Event_location_3 foreign key (location_id) references Location (location_id) on delete restrict on update restrict;
create index ix_Event_location_3 on Event (location_id);
alter table Event add constraint fk_Event_startDate_4 foreign key (fuzzy_startdate) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Event_startDate_4 on Event (fuzzy_startdate);
alter table Event add constraint fk_Event_endDate_5 foreign key (fuzzy_enddate) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Event_endDate_5 on Event (fuzzy_enddate);
alter table Life_Event add constraint fk_Life_Event_location_6 foreign key (location_id) references Location (location_id) on delete restrict on update restrict;
create index ix_Life_Event_location_6 on Life_Event (location_id);
alter table Life_Event add constraint fk_Life_Event_question_7 foreign key (question_question_id) references Question (question_id) on delete restrict on update restrict;
create index ix_Life_Event_question_7 on Life_Event (question_question_id);
alter table Life_Event add constraint fk_Life_Event_startDate_8 foreign key (fuzzy_startdate) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Life_Event_startDate_8 on Life_Event (fuzzy_startdate);
alter table Life_Event add constraint fk_Life_Event_endDate_9 foreign key (fuzzy_enddate) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Life_Event_endDate_9 on Life_Event (fuzzy_enddate);
alter table Memento add constraint fk_Memento_lifeStory_10 foreign key (life_event_id) references Life_Event (life_event_id) on delete restrict on update restrict;
create index ix_Memento_lifeStory_10 on Memento (life_event_id);
alter table Memento add constraint fk_Memento_location_11 foreign key (location_id) references Location (location_id) on delete restrict on update restrict;
create index ix_Memento_location_11 on Memento (location_id);
alter table Memento add constraint fk_Memento_question_12 foreign key (question_question_id) references Question (question_id) on delete restrict on update restrict;
create index ix_Memento_question_12 on Memento (question_question_id);
alter table Memento add constraint fk_Memento_startDate_13 foreign key (fuzzy_startdate) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Memento_startDate_13 on Memento (fuzzy_startdate);
alter table Memento add constraint fk_Memento_endDate_14 foreign key (fuzzy_enddate) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Memento_endDate_14 on Memento (fuzzy_enddate);
alter table Person add constraint fk_Person_fuzzy_birthdate_15 foreign key (birthdate_fuzzy_id) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Person_fuzzy_birthdate_15 on Person (birthdate_fuzzy_id);
alter table Person add constraint fk_Person_fuzzy_deathdate_16 foreign key (deathdate_fuzzy_id) references Fuzzy_Date (fuzzy_date_id) on delete restrict on update restrict;
create index ix_Person_fuzzy_deathdate_16 on Person (deathdate_fuzzy_id);
alter table Person add constraint fk_Person_birthplace_17 foreign key (birthplace_id) references City (person_id) on delete restrict on update restrict;
create index ix_Person_birthplace_17 on Person (birthplace_id);
alter table Person add constraint fk_Person_nation_18 foreign key (nationality_country_id) references Country (country_id) on delete restrict on update restrict;
create index ix_Person_nation_18 on Person (nationality_country_id);
alter table Contex_Index add constraint fk_Contex_Index_city_19 foreign key (city_id) references City (person_id) on delete restrict on update restrict;
create index ix_Contex_Index_city_19 on Contex_Index (city_id);
alter table Question_Trans add constraint fk_Question_Trans_question_20 foreign key (question_id) references Question (question_id) on delete restrict on update restrict;
create index ix_Question_Trans_question_20 on Question_Trans (question_id);
alter table User add constraint fk_User_person_21 foreign key (person_id) references Person (person_id) on delete restrict on update restrict;
create index ix_User_person_21 on User (person_id);



alter table Context_Content add constraint fk_Context_Content_Context_01 foreign key (context_id) references Context (context_id) on delete restrict on update restrict;

alter table Context_Content add constraint fk_Context_Content_Contex_Ind_02 foreign key (context_index_id) references Contex_Index (context_index_id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists City;

drop table if exists Context;

drop table if exists Context_Content;

drop table if exists Country;

drop table if exists Works;

drop table if exists Event;

drop table if exists Famous_Person;

drop table if exists Fuzzy_Date;

drop table if exists Life_Event;

drop table if exists Location;

drop table if exists Media;

drop table if exists Memento;

drop table if exists Person;

drop table if exists Contex_Index;

drop table if exists Question;

drop table if exists Question_Trans;

drop table if exists timeline;

drop table if exists User;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists City_seq;

drop sequence if exists Context_seq;

drop sequence if exists Country_seq;

drop sequence if exists Works_seq;

drop sequence if exists Event_seq;

drop sequence if exists Famous_Person_seq;

drop sequence if exists Fuzzy_Date_seq;

drop sequence if exists Life_Event_seq;

drop sequence if exists Location_seq;

drop sequence if exists Media_seq;

drop sequence if exists Memento_seq;

drop sequence if exists Person_seq;

drop sequence if exists Contex_Index_seq;

drop sequence if exists Question_seq;

drop sequence if exists Question_Trans_seq;

drop sequence if exists timeline_seq;

drop sequence if exists User_seq;

