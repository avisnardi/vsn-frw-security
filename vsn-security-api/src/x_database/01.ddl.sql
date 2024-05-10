-- public.tb_application definition

-- Drop table

-- DROP TABLE public.tb_application;

CREATE TABLE public.tb_application (
	id varchar(255) NOT NULL,
	"name" varchar(255) NULL,
	description varchar(255) NULL,
	CONSTRAINT pk_application PRIMARY KEY (id)
);

-- public.tb_tenant definition

-- Drop table

-- DROP TABLE public.tb_tenant;

CREATE TABLE public.tb_tenant (
	id varchar(255) NOT NULL,
	code varchar(255) NULL,
	"name" varchar(255) NULL,
	CONSTRAINT pk_tenant PRIMARY KEY (id)
);

-- public.tb_resource definition

-- Drop table

-- DROP TABLE public.tb_resource;

CREATE TABLE public.tb_resource (
	id varchar(255) NOT NULL,
	application_id varchar(255) NOT NULL,
	code varchar(255) NULL,
	description varchar(255) NULL,
	CONSTRAINT pk_resource PRIMARY KEY (id),
	CONSTRAINT fk_resource_01 FOREIGN KEY (application_id) REFERENCES public.tb_application(id)
);


-- public.tb_role definition

-- Drop table

-- DROP TABLE public.tb_role;

CREATE TABLE public.tb_role (
	id varchar(255) NOT NULL,
	tenant_id varchar(255) NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT pk_role PRIMARY KEY (id),
	CONSTRAINT fk_role_01 FOREIGN KEY (tenant_id) REFERENCES public.tb_tenant(id)
);


-- public.tb_user definition

-- Drop table

-- DROP TABLE public.tb_user;

CREATE TABLE public.tb_user (
	id varchar(255) NOT NULL,
	email varchar(255) NULL,
	login varchar(255) NULL,
	password_hash varchar(255) NULL,
	temp_role varchar(255) NULL,
	tenant_id varchar(255) NOT NULL,
	CONSTRAINT pk_user PRIMARY KEY (id),
	CONSTRAINT fk_user_01 FOREIGN KEY (tenant_id) REFERENCES public.tb_tenant(id)
);


-- public.tb_resource_role definition

-- Drop table

-- DROP TABLE public.tb_resource_role;

CREATE TABLE public.tb_resource_role (
	resource_id varchar(255) NOT NULL,
	role_id varchar(255) NOT NULL,
	CONSTRAINT pk_resource_role_01 PRIMARY KEY (resource_id, role_id),
	CONSTRAINT fk_resource_role_01 FOREIGN KEY (role_id) REFERENCES public.tb_role(id),
	CONSTRAINT fk_resource_role_02 FOREIGN KEY (resource_id) REFERENCES public.tb_resource(id)
);


-- public.tb_role_user definition

-- Drop table

-- DROP TABLE public.tb_role_user;

CREATE TABLE public.tb_role_user (
	role_id varchar(255) NOT NULL,
	user_id varchar(255) NOT NULL,
	CONSTRAINT pk_role_user PRIMARY KEY (role_id, user_id),
	CONSTRAINT fk_role_user_01 FOREIGN KEY (user_id) REFERENCES public.tb_user(id),
	CONSTRAINT fk_role_user_02 FOREIGN KEY (role_id) REFERENCES public.tb_role(id)
);