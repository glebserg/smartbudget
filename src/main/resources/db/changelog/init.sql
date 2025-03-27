CREATE TABLE users
(
    user_id      SERIAL PRIMARY KEY,
    first_name   VARCHAR(20) NOT NULL,
    second_name  VARCHAR(20) NOT NULL,
    created_date timestamp   NOT NULL DEFAULT now(),
    updated_date timestamp   NOT NULL DEFAULT now()
);

COMMENT ON TABLE users is 'Пользователи';
COMMENT ON COLUMN users.user_id is 'ID';
COMMENT ON COLUMN users.first_name is 'Имя';
COMMENT ON COLUMN users.second_name is 'Фамилия';
COMMENT ON COLUMN users.created_date is 'Дата добавления';
COMMENT ON COLUMN users.updated_date is 'Дата обновления';


CREATE TABLE income_categories
(
    income_category_id SERIAL PRIMARY KEY,
    user_id            INT REFERENCES users ON DELETE CASCADE,
    title              VARCHAR(20)  NOT NULL,
    description        VARCHAR(100) NOT NULL
);

COMMENT ON TABLE income_categories is 'Категории доходов';
COMMENT ON COLUMN income_categories.income_category_id is 'ID';
COMMENT ON COLUMN income_categories.user_id is 'ID пользователя';
COMMENT ON COLUMN income_categories.title is 'Заголовок';
COMMENT ON COLUMN income_categories.description is 'Описание';

CREATE TABLE incomes
(
    income_id          SERIAL PRIMARY KEY,
    income_category_id INT   REFERENCES income_categories ON DELETE SET NULL,
    user_id            INT REFERENCES users ON DELETE CASCADE,
    value              FLOAT NOT NULL
);
COMMENT ON TABLE incomes is 'Доходы';
COMMENT ON COLUMN incomes.income_id is 'ID';
COMMENT ON COLUMN incomes.income_category_id is 'ID категории дохода';
COMMENT ON COLUMN incomes.user_id is 'ID Пользователя';
COMMENT ON COLUMN incomes.value is 'Значение';


CREATE TABLE outlay_categories
(
    outlay_category_id SERIAL PRIMARY KEY,
    user_id            INT REFERENCES users ON DELETE CASCADE,
    priority           SMALLINT NOT NULL CHECK (priority IN (0, 1, 2))
);
COMMENT ON TABLE outlay_categories is 'Категории расходов';
COMMENT ON COLUMN outlay_categories.outlay_category_id is 'ID';
COMMENT ON COLUMN outlay_categories.user_id is 'ID Пользователя';
COMMENT ON COLUMN outlay_categories.priority is 'Приоритет (0-обязательно, 1-комфорт, 2-вредно)';

CREATE TABLE outlays
(
    outlay_id          SERIAL PRIMARY KEY,
    user_id            INT REFERENCES users ON DELETE CASCADE,
    outlay_category_id INT   REFERENCES outlay_categories ON DELETE SET NULL,
    value              FLOAT NOT NULL,
    comment            VARCHAR(100)
);
COMMENT ON TABLE outlays is 'Расходы';
COMMENT ON COLUMN outlays.outlay_id is 'ID';
COMMENT ON COLUMN outlays.user_id is 'ID Пользователя';
COMMENT ON COLUMN outlays.outlay_category_id is 'Категория расхода';
COMMENT ON COLUMN outlays.value is 'Значение';
COMMENT ON COLUMN outlays.comment is 'Комментарий';


CREATE TABLE purposes
(
    purpose_id          SERIAL PRIMARY KEY,
    user_id            INT REFERENCES users ON DELETE CASCADE,
    purpose_date INT   REFERENCES outlay_categories ON DELETE SET NULL,
    value              FLOAT NOT NULL,
    title              VARCHAR(20)  NOT NULL,
    description        VARCHAR(100) NOT NULL
);
COMMENT ON TABLE purposes is 'Цели';
COMMENT ON COLUMN purposes.user_id is 'ID Пользователя';
COMMENT ON COLUMN purposes.purpose_date is 'Дата достижения цели';
COMMENT ON COLUMN purposes.value is 'Значение';
COMMENT ON COLUMN purposes.title is 'Заголовок';
COMMENT ON COLUMN purposes.description is 'Описание';