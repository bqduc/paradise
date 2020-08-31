/**
 * 
 */
package net.ecoparadise.framework.entity;

import java.io.Serializable;

/**
 * @author bqduc
 *
 */
public abstract class EntityBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract Long getId();

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(getClass().getCanonicalName()).append("[id=").append(getId()).append("]");
		return result.toString();
	}

	 /**
   * Determines whether another object is equal to this business object.  The result is 
   * <code>true</code> if and only if the argument is not null and is a business object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!getClass().isInstance(object)) {
			return false;
		}

		EntityBase other = (EntityBase) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId())))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
	}

	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode())
			return 1;
		else if (obj.hashCode() < hashCode())
			return -1;

		return 0;
	}
}
