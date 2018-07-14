INSERT INTO `guardianpro`.`pages` (`page_id`, `page_name`) VALUES ('28', 'Log_SMTP');
INSERT INTO `guardianpro`.`pages` (`page_id`, `page_name`) VALUES ('29', 'Log_download');
INSERT INTO `guardianpro`.`pages` (`page_id`, `page_name`) VALUES ('30', 'Log_ftp');

INSERT INTO `guardianpro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES ('131', 'Logs_FTP_Logs', 'Logs_FTP_Logs', '129', 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `guardianpro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES ('132', 'Log_SMTP_logs', 'Log_SMTP logs', '128', 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');
INSERT INTO `guardianpro`.`component` (`ID`, `name`, `Description`, `Parent_ID`, `Type`, `create_date`, `update_date`, `C_name`) VALUES ('133', 'Log_download_logs', 'Log_download_logs', '127', 'Component', '2018-04-12 23:48:54', '2018-04-12 23:48:54', 'a');


INSERT INTO `guardianpro`.`role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES ('254', '1', '1', '2018-04-12 23:48:54', '2018-04-12 23:48:54', '1', '131');
INSERT INTO `guardianpro`.`role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES ('255', '1', '1', '2018-04-12 23:48:54', '2018-04-12 23:48:54', '1', '132');
INSERT INTO `guardianpro`.`role_has_component` (`ID`, `view`, `edit`, `create_date`, `update_date`, `Role_ID`, `component_ID`) VALUES ('256', '1', '1', '2018-04-12 23:48:54', '2018-04-12 23:48:54', '1', '133');


INSERT INTO `guardianpro`.`component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES ('128', 'Logs_Download_Log', 'Logs_Download_Log', 'Logs_Download_Log', '0', '2018-04-12 23:48:54', '2018-04-12 23:48:54', '133');
INSERT INTO `guardianpro`.`component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES ('129', 'Log_SMTP_Logs', 'Log_SMTP_Logs', 'Log_SMTP_Logs', '0', '2018-04-12 23:48:54', '2018-04-12 23:48:54', '132');

INSERT INTO `guardianpro`.`component_name` (`ID`, `Name`, `Value`, `Description`, `Edit`, `create_date`, `update_date`, `component_component_ID`) VALUES ('130', 'Logs', 'Logs', 'Logs', '0', '2018-04-12 23:48:54', '2018-04-12 23:48:54', '130');
