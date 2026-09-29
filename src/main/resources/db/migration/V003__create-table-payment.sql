create table public.payment (
  id uuid not null,
  associate_id uuid not null,
  due_date date,
  payment_date date,
  amount numeric(15, 2),
  primary key (id)
);