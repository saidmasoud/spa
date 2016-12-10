Set objExcel = CreateObject("Excel.Application")
Set objWorkbook = objExcel.Workbooks.Open("<excel_file_path>")

objExcel.Visible = True
objExcel.Run "TransformR1Data"
'sleep for 15 seconds
WScript.Sleep 15000
objExcel.Run "TransformR2Data"
objWorkbook.Save
objWorkbook.Close
objExcel.Quit

Set objWorkbook = Nothing
Set objExcel = Nothing

WScript.Quit