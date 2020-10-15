CREATE TABLE IF NOT EXISTS PIPES (
	START_POINT int,
	END_POINT int,
	LENGTH int
);
CREATE INDEX IF NOT EXISTS CITY_NAME_INDEX on PIPES(START_POINT);
CREATE INDEX IF NOT EXISTS CITY_NAME_INDEX on PIPES(END_POINT);