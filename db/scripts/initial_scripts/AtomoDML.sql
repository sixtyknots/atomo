use atomo;

/*-------------------------------------------------------------------------------*/

delete from participanttype;

insert into participanttype (id, name)
values ('MERCHANT', 'Merchant');

insert into participanttype (id, name)
values ('BUYER', 'Buyer');

/*-------------------------------------------------------------------------------*/

delete from binarydatatype;

insert into binarydatatype (id, name)
values ('IMAGE', 'Image');

/*-------------------------------------------------------------------------------*/

delete from transactionstatustype;

insert into transactionstatustype (id, name)
values ('PENDING', 'Pending');

insert into transactionstatustype (id, name)
values ('EXECUTED', 'Executed');

insert into transactionstatustype (id, name)
values ('CANCELLED', 'Cancelled');

/*-------------------------------------------------------------------------------*/

delete from transactiontype;

insert into transactiontype (id, name)
values ('PAYMENT', 'Debit transaction from one''s account for payment purpose.');

insert into transactiontype (id, name)
values ('FEE', 'Debit transaction from one''s account for fee payment purpose.');

insert into transactiontype (id, name)
values ('GIFT_CARD_RECEIVE', 'Credit transaction to one''s account - gift card received.');

insert into transactiontype (id, name)
values ('DEPOSIT', 'Credit transaction to one''s account - deposit');

/*-------------------------------------------------------------------------------*/
