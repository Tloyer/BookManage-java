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
    IN page INTEGER, --从1开始的页码
    IN maxPage INTEGER, --每页含有的数据数量
    IN bookName VARCHAR, --书名
    IN bookAuthor VARCHAR, --作者
    OUT book_id INTEGER,
    OUT book_name VARCHAR,
    OUT book_author VARCHAR,
    OUT isbn VARCHAR,
    OUT stock INTEGER
)
RETURN SETOF record
AS
DECLARE
    deviation INTEGER;
result    record;
BEGIN
deviation:=(page-1)*maxPage;
FOR result IN
SELECT *
FROM book
WHERE book.book_name LIKE '%' || bookName || '%'
  AND book.book_author LIKE '%' || bookAuthor || '%'
LIMIT deviation, maxPage LOOP book_id:=result.book_id;
book_name:=result.book_name;
book_author:=result.book_author;
isbn:=result.isbn;
stock:=result.stock;
RETURN NEXT;
END LOOP;
END;

--使用该函数的例子
SELECT *
FROM SELECT_BOOK_FUNC(2, 2, '1', '1');