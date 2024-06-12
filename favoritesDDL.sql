
CREATE TABLE favorites (
    user_id VARCHAR(255) NOT NULL,
    sys_id VARCHAR(255) NOT NULL,
    question TEXT NOT NULL,
    answer TEXT NOT NULL,
    keyword TEXT,
    saved_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(user_id, sys_id)
)

