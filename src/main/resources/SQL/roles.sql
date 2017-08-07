-- Table: public.roles

-- DROP TABLE public.roles;

CREATE TABLE public.roles
(
    id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.roles
    OWNER to "MickeyMaus";

GRANT ALL ON TABLE public.roles TO "MickeyMaus" WITH GRANT OPTION;