import json
import importlib
import sys
import modules.utils as utils
import traceback

try:
  # get json context string
  args = sys.argv
  input_path = args[1]

  input_file = open(input_path)
  all_args = json.load(input_file)

  function_string = "modules." + all_args["keyword"]
  mod_name, func_name = function_string.rsplit(".", 1)
  mod = importlib.import_module(mod_name)
  func = getattr(mod, func_name)

  output = None
  assert_error = None
  other_error = None
  try:
    func_args = [ all_args ] + all_args["keywordArgs"]
    output = func(*func_args)
  except AssertionError as e:
    assert_error = traceback.format_exc()
    traceback.print_exc()
  except:
    other_error = traceback.format_exc()
    traceback.print_exc()

  # write output and log to file
  print("Finish Python keyword execution")
  output_path = all_args["outputPath"]
  f = open(output_path,"w+")
  json.dump(
    {
      "assertError": assert_error,
      "error": other_error,
      "output": output
    },
    f)
except:
  error = traceback.format_exc()
  traceback.print_exc()
