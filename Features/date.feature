Feature: Dates with different date formats
  This feature shows you can have different date formats, as long as you annotate the
  corresponding step definition method accordingly.

  @tag
  Scenario Outline: eating
    Given there are <start> cucumbers

    Examples:
      | start |
      |    12 |
      |    20 |
