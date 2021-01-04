package com.sdzee.beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-12-30T02:57:58.346+0100")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ {
	public static volatile SingularAttribute<Utilisateur, Integer> idUtilisateur;
	public static volatile SingularAttribute<Utilisateur, String> login;
	public static volatile SingularAttribute<Utilisateur, String> password;
	public static volatile ListAttribute<Utilisateur, Charactercss> listChara;
}
