package br.com.codecode.workix.model.pojo;

import java.sql.Timestamp;

public abstract interface BaseEntity {

	long getId();

	void setId(final long id);

	int getVersion();

	void setVersion(final int version);

	Timestamp getCreatedAt();

	void setCreatedAt(Timestamp createdAt);

	Timestamp getUpdatedAt();

	void setUpdatedAt(Timestamp updatedAt);

	String getUuid();

	void setUuid(String uuid);

}
