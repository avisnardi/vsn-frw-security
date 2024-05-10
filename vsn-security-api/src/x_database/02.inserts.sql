INSERT INTO public.tb_application (id,"name",description) VALUES
	 ('1','Nova Cifra','Editor de Cifras'),
	 ('2','Gym Base','Acadêmia');

INSERT INTO public.tb_tenant (id,code,"name") VALUES
	 ('1','vsn.cifra','Visna Cifra'),
	 ('2','vsn.fitness','Visna Fit');

INSERT INTO public.tb_user (id,email,login,password_hash,temp_role,tenant_id) VALUES
	 ('1','avisnardi',NULL,'mkdmklamdlkam','admin','1'),
	 ('2','kvisnardi',NULL,'90902390-239','admin','2');

