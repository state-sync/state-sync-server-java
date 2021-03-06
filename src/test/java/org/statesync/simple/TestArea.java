package org.statesync.simple;

import org.statesync.InMemoryStateStorage;
import org.statesync.SyncArea;
import org.statesync.SyncAreaApi;
import org.statesync.config.SyncAreaConfig;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestArea extends SyncArea<TestModel> {
	static final SyncAreaConfig<TestModel> config = new SyncAreaConfig<>();
	static InMemoryStateStorage storage = new InMemoryStateStorage();
	static {
		config.setId("test");
		config.setModel(TestModel.class);
	}

	protected static TestModel process(final TestModel model, final SyncAreaApi<TestModel> user) {
		return model;
	}

	protected static TestModel signal(final TestModel model, final SyncAreaApi<TestModel> user, final String signal,
			final ObjectNode parameters) {
		return model;
	}

	public TestArea() {
		super(config, storage, TestArea::process, TestArea::signal);
	}
}
