use master

begin try
  alter database JavaProject set single_user with rollback immediate
  drop database JavaProject
end try
begin catch end catch

create database JavaProject
go
use JavaProject
go

/* TABLES */

create table [User]
(
  Id int primary key identity,
  Username nvarchar(256) not null unique,
  PasswordHash nvarchar(256) not null,
  [Role] nvarchar(256) default 'User',
)
create table Idea
(
  Id int primary key identity,
  Title nvarchar(256),
  Link nvarchar(512) unique,
  [Description] nvarchar(max),
  PicturePath nvarchar(256),
  PublishedDate datetime2,
  SymbolId int,
  MarketId int,
)
create table Author
(
  Id int primary key identity,
  [Name] nvarchar(256),
  Link nvarchar(512) unique,
)
create table IdeaAuthor
(
  Id int primary key identity,
  IdeaId int,
  AuthorId int,
)
create table Symbol
(
  Id int primary key identity,
  [Name] nvarchar(256),
  [Description] nvarchar(256),
  Link nvarchar(512) unique,
)
create table Market
(
  Id int primary key identity,
  [Name] nvarchar(256) unique,
  IsSelected bit default 0,
)
go
alter table Idea add
  constraint FK_Idea_Symbol foreign key (SymbolId)
    references Symbol(Id) on delete cascade,
  constraint FK_Idea_Market foreign key (MarketId)
    references Market(Id) on delete cascade
alter table IdeaAuthor add
  constraint FK_IdeaAuthor_Idea foreign key (IdeaId)
    references Idea(Id) on delete cascade,
  constraint FK_IdeaAuthor_Author foreign key (AuthorId)
    references Author(Id) on delete cascade
alter table IdeaAuthor add
  constraint UQ_IdeaAuthorUnique unique (IdeaId, AuthorId)
go

/* PROCEDURES */

/* USER */
create procedure CreateUser
  @Username nvarchar(256),
  @PasswordHash nvarchar(256),
  @Role nvarchar(256),
  @Id int output
as
  begin
    insert into [User] values (@Username, @PasswordHash, @Role)
    set @Id = SCOPE_IDENTITY()
  end
go
create procedure SelectUserByUsername @Username nvarchar(256) as
  select * from [User] where Username = @Username
go

/* IDEA */
create procedure CreateIdea
  @Title nvarchar(256),
  @Link nvarchar(512),
  @Description nvarchar(max),
  @PicturePath nvarchar(256),
  @PublishedDate datetime2,
  @SymbolId int,
  @MarketId int,
  @Id int output
as
  begin
    insert into Idea values (@Title, @Link, @Description, @PicturePath, @PublishedDate, @SymbolId, @MarketId)
    set @Id = SCOPE_IDENTITY()
  end
go
create procedure UpdateIdea
  @Id int,
  @Title nvarchar(256),
  @Link nvarchar(512),
  @Description nvarchar(max),
  @PicturePath nvarchar(256),
  @PublishedDate datetime2,
  @SymbolId int,
  @MarketId int
as
  update Idea set
    Title = @Title,
    Link = @Link,
    [Description] = @Description,
    PicturePath = @PicturePath,
    PublishedDate = @PublishedDate,
    SymbolId = @SymbolId,
    MarketId = @MarketId
  where Id = @Id
go
create procedure DeleteIdea @Id int as
  delete from Idea where Id = @Id
go
create view IdeaJoined as
  select
    Idea.[Id],
    Idea.[Title],
    Idea.[Link],
    Idea.[Description],
    Idea.[PicturePath],
    Idea.[PublishedDate],
    Symbol.[Id] as SymbolId,
    Symbol.[Name] as SymbolName,
    Symbol.[Description] as SymbolDescription,
    Symbol.[Link] as SymbolLink,
    Market.[Id] as MarketId,
    Market.[Name] as MarketName,
    Market.[IsSelected] as MarketIsSelected
  from Idea
    inner join Symbol on Idea.SymbolId = Symbol.Id
    inner join Market on Idea.MarketId = Market.Id
go
create procedure SelectIdea @Id int as
  select * from IdeaJoined where Id = @Id
go
create procedure SelectIdeas as
  select * from IdeaJoined
go

/* AUTHOR */
create procedure CreateAuthor
  @Name nvarchar(256),
  @Link nvarchar(512),
  @Id int output
as
  begin
    insert into Author values (@Name, @Link)
    set @Id = SCOPE_IDENTITY()
  end
go
create procedure UpdateAuthor
  @Id int,
  @Name nvarchar(256),
  @Link nvarchar(512)
as
  update Author set
    [Name] = @Name,
    Link = @Link
  where Id = @Id
go
create procedure DeleteAuthor @Id int as
  delete from Author where Id = @Id
go
create procedure SelectAuthor @Id int as
  select * from Author where Id = @Id
go
create procedure SelectAuthors as
  select * from Author
go

/* IDEA_AUTHOR */
create procedure CreateIdeaAuthor
  @IdeaId int,
  @AuthorId int,
  @Id int output
as
  begin
    insert into IdeaAuthor values (@IdeaId, @AuthorId)
    set @Id = SCOPE_IDENTITY()
  end
go
create procedure DeleteIdeaAuthorByIdeaId @IdeaId int as
  delete from IdeaAuthor where IdeaAuthor.IdeaId = @IdeaId
go
create procedure SelectAuthorIdsByIdeaId @IdeaId int as
  select AuthorId from IdeaAuthor where IdeaAuthor.IdeaId = @IdeaId
go

/* SYMBOL */
create procedure CreateSymbol
  @Name nvarchar(256),
  @Description nvarchar(256),
  @Link nvarchar(512),
  @Id int output
as
  begin
    insert into Symbol values (@Name, @Description, @Link)
    set @Id = SCOPE_IDENTITY()
  end
go
create procedure UpdateSymbol
  @Id int,
  @Name nvarchar(256),
  @Description nvarchar(256),
  @Link nvarchar(512)
as
  update Symbol set
    [Name] = @Name,
    [Description] = @Description,
    Link = @Link
  where Id = @Id
go
create procedure DeleteSymbol @Id int as
  delete from Symbol where Id = @Id
go
create procedure SelectSymbols as
  select * from Symbol
go

/* MARKET */
create procedure CreateMarket
  @Name nvarchar(256),
  @IsSelected bit,
  @Id int output
as
  begin
    insert into Market values (@Name, @IsSelected)
    set @Id = SCOPE_IDENTITY()
  end
go
create procedure SetSelectedMarket
  @Id int,
  @IsSelected bit
as
  update Market set IsSelected = @IsSelected where Id = @Id
go
create procedure SelectMarkets as
  select * from Market
go

/* OTHER */
create procedure DeleteAllContent as
  begin
    delete from Idea
    delete from IdeaAuthor
    delete from Author
    delete from Symbol
    dbcc checkident('Idea', reseed, 0)
    dbcc checkident('IdeaAuthor', reseed, 0)
    dbcc checkident('Author', reseed, 0)
    dbcc checkident('Symbol', reseed, 0)
  end

/* INSERTIONS */

/* USERS */
declare @Id int
exec CreateUser 'admin', '$2a$12$0makz2dfh.F8EjXONaQq1O2QuotAZc33lrRcXHzFJ2ZSBXMuEK0ma', 'ADMIN', @Id output
exec CreateUser 'user', '$2a$12$XIOs1Mas/1VDxO4jUe5rG.VGNVZrilvwwwqiUR2fEBFnOXsGqSyNq', 'USER', @Id output
go

/* MARKETS */
declare @Id int
exec CreateMarket 'Commodities', 0, @Id output
exec CreateMarket 'Crypto', 0, @Id output
exec CreateMarket 'Currencies', 0, @Id output
exec CreateMarket 'Indices', 0, @Id output
exec CreateMarket 'Stocks', 0, @Id output
go