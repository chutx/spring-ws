package com.training.neo4j.dao.entities;

import org.springframework.data.neo4j.annotation.GraphId;

public abstract class BaseEntity {

	@GraphId
	private Long nodeId;
	
	public BaseEntity() { }
	
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (nodeId == null || obj == null || !getClass().equals(obj.getClass())) {
			return false;
		}
		return nodeId.equals(((BaseEntity) obj).nodeId);
	}

	@Override
	public int hashCode() {
		return nodeId == null ? 0 : nodeId.hashCode();
	}
}
