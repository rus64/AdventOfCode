import Day5.*

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class Day5Spec extends AnyFlatSpec with should.Matchers:

    // Parse

    "parse crates in example.txt" should "return crates" in {
        val input = List(
            "    [D]    ",
            "[N] [C]    ",
            "[Z] [M] [P]",
            " 1   2   3 "
        )
        val expected = List(
            List('N','Z'),
            List('D','C','M'),
            List('P')
        )

        val crates = parseCrates(input)
        crates shouldBe expected
    }

    "parse actions in example.txt" should "return a list of actions" in {
        val input = List(
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2",
        )
        val expected = List(
            Action(1, 2, 1),
            Action(3, 1, 3),
            Action(2, 2, 1),
            Action(1, 1, 2)
        )

        val actions = parseActions(input)
        actions shouldBe expected
    }

    "parse example.txt" should "return Input" in {
        val input = List(
            "    [D]           ",
            "[N] [C]           ",
            "[Z] [M] [P]       ",
            " 1   2   3        ",
            "                  ",
            "move 1 from 2 to 1",
            "move 3 from 1 to 3",
            "move 2 from 2 to 1",
            "move 1 from 1 to 2",
        )
        val crates = List(
            List('N','Z'),
            List('D','C','M'),
            List('P')
        )
        val actions = List(
            Action(1, 2, 1),
            Action(3, 1, 3),
            Action(2, 2, 1),
            Action(1, 1, 2)
        )
        val expected = Input(crates, actions) 
        parse(input) shouldBe expected
    }

    // Part 1

    "Part 1: 1st move in example" should "move 1 from 2 to 1 (one by one)" in {
        val stacks = List(
            List('N','Z'),
            List('D','C','M'),
            List('P')
        )
        val action = Action(1, 2, 1)
        val expected = List(
            List('D','N','Z'),
            List('C','M'),
            List('P')
        )
        val result = move(stacks, action, false)
        result shouldBe expected
    }

    "Part 1: 2nd move in example" should "move 3 from 1 to 3 (one by one)" in {
        val stacks = List(
            List('D','N','Z'),
            List('C','M'),
            List('P')
        )
        val action = Action(3, 1, 3)
            val expected = List(
            List(),
            List('C','M'),
            List('Z','N','D','P')
        )
        val result = move(stacks, action, false)
        result shouldBe expected
    }

    "Part 1: 3rd move in example" should "move 2 from 2 to 1 (one by one)" in {
        val stacks = List(
            List(),
            List('C','M'),
            List('Z','N','D','P')
        )
        val action = Action(2, 2, 1)
        val expected = List(
            List('M','C'),
            List(),
            List('Z','N','D','P')
        )
        val result = move(stacks, action, false)
        result shouldBe expected
    }

    "Part 1: 4th move in example" should "move 1 from 1 to 2 (one by one)" in {
        val stacks = List(
            List('M','C'),
            List(),
            List('Z','N','D','P')
        )
        val action = Action(1, 1, 2)
        val expected = List(
            List('C'),
            List('M'),
            List('Z','N','D','P')
        )
        val result = move(stacks, action, false)
        result shouldBe expected
    }

    // Part 2

    "Part 2: 1st move in example" should "move 1 from 2 to 1 (keeping the order)" in {
        val stacks = List(
            List('N','Z'),
            List('D','C','M'),
            List('P')
        )
        val action = Action(1, 2, 1)
        val expected = List(
            List('D','N','Z'),
            List('C','M'),
            List('P')
        )
        val result = move(stacks, action, true)
        result shouldBe expected
    }

    "Part 2: 2nd move in example" should "move 3 from 1 to 3 (keeping the order)" in {
        val stacks = List(
            List('D','N','Z'),
            List('C','M'),
            List('P')
        )
        val action = Action(3, 1, 3)
        val expected = List(
            List(),
            List('C', 'M'),
            List('D','N','Z','P')
        )
        val result = move(stacks, action, true)
        result shouldBe expected
    }

    "Part 2: 3rd move in example" should "move 2 from 2 to 1 (keeping the order)" in {
        val stacks = List(
            List(),
            List('C','M'),
            List('D','N','Z','P')
        )
        val action = Action(2, 2, 1)
        val expected = List(
            List('C','M'),
            List(),
            List('D','N','Z','P')
        )
        val result = move(stacks, action, true)
        result shouldBe expected
    }

    "Part 2: 4th move in example" should "move 1 from 1 to 2 (keeping the order)" in {
        val stacks = List(
            List('C','M'),
            List(),
            List('D','N','Z','P')
        )
        val action = Action(1, 1, 2)
        val expected = List(
            List('M'),
            List('C'),
            List('D','N','Z','P')
        )
        val result = move(stacks, action, true)
        result shouldBe expected
    }

    // Solve

    "solve example.txt" should "return CMZ" in {
        solve("example.txt") shouldBe Output("CMZ", "MCD")
    }

    "solve challenge.txt" should "return FRDSQRRCD" in {
        solve("challenge.txt") shouldBe Output("FRDSQRRCD", "HRFTQVWNN")
    }


end Day5Spec
