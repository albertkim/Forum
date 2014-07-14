// Convert a css px value to int.
function ConvertCssPxToInt(cssPxValueText) {
    // Set valid characters for numeric number.
    var validChars = "0123456789.";
    // If conversion fails return 0.
    var convertedValue = 0;
    // Loop all characters of
    for (i = 0; i < cssPxValueText.length; i++) {
        // Stop search for valid numeric characters,  when a none numeric number is found.
        if (validChars.indexOf(cssPxValueText.charAt(i)) === -1) {
            // Start conversion if at least one character is valid.
            if (i > 0) {
                // Convert validnumbers to int and return result.
                convertedValue = parseInt(cssPxValueText.substring(0, i));
                return convertedValue;
            }
        }
    }
    return convertedValue;
}