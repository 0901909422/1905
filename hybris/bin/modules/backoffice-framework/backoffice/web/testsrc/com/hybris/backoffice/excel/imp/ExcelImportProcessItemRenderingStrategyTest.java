/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.excel.imp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import de.hybris.platform.core.model.media.MediaModel;
import de.hybris.platform.cronjob.model.CronJobHistoryModel;

import org.junit.Test;

import com.hybris.backoffice.model.ExcelImportCronJobModel;


public class ExcelImportProcessItemRenderingStrategyTest
{

	@Test
	public void shouldHandleJobWhenJobIsExcelJob()
	{
		// given
		final ExcelImportProcessItemRenderingStrategy strategy = new ExcelImportProcessItemRenderingStrategy();
		final CronJobHistoryModel cronJobHistoryModel = new CronJobHistoryModel();
		final ExcelImportCronJobModel excelImportCronJobModel = new ExcelImportCronJobModel();
		cronJobHistoryModel.setCronJob(excelImportCronJobModel);

		// when
		final boolean canHandle = strategy.canHandle(cronJobHistoryModel);

		// then
		assertThat(canHandle).isTrue();
	}

	@Test
	public void shouldReturnCorrectJobTitle()
	{
		// given
		final ExcelImportProcessItemRenderingStrategy strategy = spy(ExcelImportProcessItemRenderingStrategy.class);
		final CronJobHistoryModel cronJobHistoryModel = new CronJobHistoryModel();
		final ExcelImportCronJobModel excelImportCronJobModel = mock(ExcelImportCronJobModel.class);
		cronJobHistoryModel.setCronJob(excelImportCronJobModel);

		final MediaModel excelFile = mock(MediaModel.class);
		given(excelImportCronJobModel.getExcelFile()).willReturn(excelFile);
		given(excelFile.getRealFileName()).willReturn("Product28052018.xlsx");
		doReturn("Excel import").when(strategy).getLabel("processes.title.excel.import.full");

		// when
		final String title = strategy.getTitle(cronJobHistoryModel);

		// then
		assertThat(title).isEqualTo("Excel import - Product28052018.xlsx");
	}
}
