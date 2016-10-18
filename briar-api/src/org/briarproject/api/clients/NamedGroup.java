package org.briarproject.api.clients;

import org.briarproject.api.nullsafety.NotNullByDefault;
import org.briarproject.api.sync.Group;
import org.jetbrains.annotations.NotNull;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@NotNullByDefault
public abstract class NamedGroup extends BaseGroup {

	private final byte[] salt;

	public NamedGroup(@NotNull Group group, @NotNull String name, byte[] salt) {
		super(group, name);
		this.salt = salt;
	}

	public byte[] getSalt() {
		return salt;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof NamedGroup && super.equals(o);
	}

}
