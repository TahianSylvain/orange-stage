CREATE TABLE diagram (
  id bigint NOT NULL PRIMARY KEY,
  bpmn2 XML,
  description varchar(255),
  title varchar(255)
);
CREATE TABLE personnel_diagrams (
  personnel_id bigint NOT NULL,
  diagram_id bigint NOT NULL,
  CONSTRAINT pk_personnel_diagram PRIMARY KEY (personnel_id, diagram_id),
  FOREIGN KEY (personnel_id) REFERENCES personnel(id),
  FOREIGN KEY (diagram_id) REFERENCES diagram(id)
);

DROP SEQUENCE IF EXISTS personnel_seq CASCADE;
DROP SEQUENCE IF EXISTS diagram_seq CASCADE;

CREATE SEQUENCE personnel_seq INCREMENT BY 1;
CREATE SEQUENCE diagram_seq INCREMENT BY 1;

ALTER TABLE personnel_diagrams ALTER COLUMN personnel_id SET DEFAULT nextval('personnel_seq');
ALTER TABLE personnel_diagrams ALTER COLUMN diagram_id SET DEFAULT nextval('diagram_seq');
alter table if exists diagram drop constraint if exists UK_i3g4wl6claj6qrrfdwnhxyoqm;
alter table if exists diagram add constraint UK_i3g4wl6claj6qrrfdwnhxyoqm unique (bpmn2);
