-- 删除书时 同时删除book表和book_detail表信息 触发器
CREATE OR REPLACE FUNCTION DELETE_BOOK_DETAIL_FUNC() RETURNS TRIGGER AS
$$
DECLARE
BEGIN
    DELETE FROM book_detail WHERE book_id = OLD.book_id;
    RETURN OLD;
END
$$ LANGUAGE PLPGSQL;

CREATE TRIGGER delete_book_trigger
    BEFORE DELETE
    ON book
    FOR EACH ROW
EXECUTE PROCEDURE DELETE_BOOK_DETAIL_FUNC();


--页码 页信息数量 %书名% %作者名% 模糊查询 limit函数 存储过程 book表
CREATE OR REPLACE FUNCTION SELECT_BOOK_FUNC(
    page INTEGER,
    maxPage INTEGER,
    bookName VARCHAR,
    bookAuthor VARCHAR
)
RETURNS SETOF book AS $$
DECLARE
    deviation INTEGER;
BEGIN
    deviation := (page - 1) * maxPage;
    RETURN QUERY
    SELECT 
        book_id, 
        book_name, 
        book_author, 
        isbn, 
        stock
    FROM 
        book
    WHERE 
        book_name LIKE '%' || bookName || '%'
        AND book_author LIKE '%' || bookAuthor || '%'
    OFFSET deviation
    LIMIT maxPage;
END;
$$ LANGUAGE plpgsql;


--使用该函数的例子
SELECT *
FROM SELECT_BOOK_FUNC(2, 2, '1', '1');

--借书前判断库存是否>=1 函数 返回值bool true-库存有 false-库存无
-- 查询库存状态函数
CREATE OR REPLACE FUNCTION SELECT_STOCK_FUNC(
    IN bookID INTEGER, 
    OUT status BOOLEAN
) 
RETURNS BOOLEAN AS $$
DECLARE
    totalStock INTEGER;
BEGIN
    SELECT stock
    INTO totalStock
    FROM book
    WHERE book_id = bookID;

    IF totalStock > 0 THEN
        status := TRUE;
    ELSE
        status := FALSE;
    END IF;

    RETURN status;
END;
$$ LANGUAGE plpgsql;

-- 使用函数的示例
SELECT * FROM SELECT_STOCK_FUNC(1);

-- 删除借书信息时触发器函数
CREATE OR REPLACE FUNCTION ADD_BOOK_STOCK_FUNC() 
RETURNS TRIGGER AS $$
BEGIN
    UPDATE book 
    SET stock = stock + 1 
    WHERE book_id = OLD.book_id;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

-- 触发器
CREATE TRIGGER delete_borrow_info_trigger
    AFTER DELETE ON borrow_info
    FOR EACH ROW
EXECUTE PROCEDURE ADD_BOOK_STOCK_FUNC();
