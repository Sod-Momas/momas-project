
CREATE TABLE "public"."cwm_group" (
  "id" int8 NOT NULL,
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" date,
  "workflow" jsonb,
  CONSTRAINT "cwm_group_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."cwm_group"
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."cwm_group"."id" IS 'id';

COMMENT ON COLUMN "public"."cwm_group"."task_name" IS '任务名';

COMMENT ON COLUMN "public"."cwm_group"."create_time" IS '创建时间';

COMMENT ON COLUMN "public"."cwm_group"."workflow" IS '任务流';


