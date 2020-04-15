CREATE TABLE "PROJECT_MEASURES"(
    "ID" BIGINT NOT NULL AUTO_INCREMENT (1,1),
    "UUID" VARCHAR(40) NOT NULL,
    "VALUE" DOUBLE,
    "METRIC_ID" INTEGER NOT NULL,
    "ANALYSIS_UUID" VARCHAR(50) NOT NULL,
    "COMPONENT_UUID" VARCHAR(50) NOT NULL,
    "TEXT_VALUE" VARCHAR(4000),
    "ALERT_STATUS" VARCHAR(5),
    "ALERT_TEXT" VARCHAR(4000),
    "DESCRIPTION" VARCHAR(4000),
    "PERSON_ID" INTEGER,
    "VARIATION_VALUE_1" DOUBLE,
    "VARIATION_VALUE_2" DOUBLE,
    "VARIATION_VALUE_3" DOUBLE,
    "VARIATION_VALUE_4" DOUBLE,
    "VARIATION_VALUE_5" DOUBLE,
    "MEASURE_DATA" BLOB
);
ALTER TABLE "PROJECT_MEASURES" ADD CONSTRAINT "PK_PROJECT_MEASURES" PRIMARY KEY("ID");
CREATE INDEX "MEASURES_ANALYSIS_METRIC" ON "PROJECT_MEASURES"("ANALYSIS_UUID", "METRIC_ID");
CREATE INDEX "MEASURES_COMPONENT_UUID" ON "PROJECT_MEASURES"("COMPONENT_UUID");
